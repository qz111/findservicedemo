package com.zq.service.strategy;


import com.zq.domain.StrategyOption;
import com.zq.domain.TestResult;
import com.zq.dao.ModuleResultDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qz111
 *
 */
/*
* Factory Mode
* mit Hilfe von angegebene StrategieOption und Modulenname, um die passende TestResult und Überprüfungsstrategien zu finden
* */
@Component
public class TestResultsFindStrategyFactory {

    public static final String TEST_CASE_RESULT = "TestCaseResult";
    public static final String MODULE_RESULT = "ModuleResult";
    public static final String GREEN_TCWITH_DEFECT = "GreenTCWithDefect";
    public static final String RED_TCNO_DEFECT = "RedTCNoDefect";
    public static final String MOD_COV_FULL_WITH_DEFECT = "ModCovFullWithDefect";
    private static ModuleResultDao moduleResultDAO;

    @Autowired
    public void setModuleDAO(ModuleResultDao moduleResultDAO) {
        TestResultsFindStrategyFactory.moduleResultDAO = moduleResultDAO;
    }

    public static List<? extends TestResult> getContent(StrategyOption tag, List<String> moduleNames) {
        if(TEST_CASE_RESULT.equals(tag.getScope())){
            return moduleResultDAO.getAllModuleTC();
        } else if(MODULE_RESULT.equals(tag.getScope())){
            return moduleResultDAO.getModule(moduleNames);
        }
        return null;
    }

    public static FindConflictsStrategy getStrategy(StrategyOption tag) {
        if(RED_TCNO_DEFECT.equals(tag.getTagName())){
            return new FindFailedTestCaseResultsWithoutDefectTicket();
        } else if(GREEN_TCWITH_DEFECT.equals(tag.getTagName())){
            return new FindSuccessTestCaseResultWithDefectTicket();
        } else if(MOD_COV_FULL_WITH_DEFECT.equals(tag.getTagName())){
            return new FindModuleResultsFullCoverageWithDefectTicket();
        }
        return null;
    }
}
