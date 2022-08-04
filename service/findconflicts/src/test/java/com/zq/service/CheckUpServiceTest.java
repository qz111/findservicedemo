package com.zq.service;

import com.zq.domain.ModuleResult;
import com.zq.domain.StrategyOption;
import com.zq.domain.TestCaseResult;
import com.zq.service.find.FindConflictsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author qz111
 */
@SpringBootTest
public class CheckUpServiceTest {

    private FindConflictsService underTest;

    @Autowired
    public void setCheckUpConflictService(FindConflictsService findConflictsService) {
        underTest = findConflictsService;
    }

    @Test
    public void shouldFindTestcasesRunOkWithDefectTicket() {
        StrategyOption strategyOption = new StrategyOption();
        strategyOption.setTagName("GreenTCWithDefect");
        strategyOption.setScope("TestCaseResult");
        Map<String, List<?>> stringListMap = underTest.doCheckUp(Arrays.asList(strategyOption), Arrays.asList("qdmabc", "qdmbbb"));
        TestCaseResult defectTestCaseResult = (TestCaseResult) stringListMap.get("GreenTCWithDefect").get(0);
        assertEquals("tc001", defectTestCaseResult.getId());
    }

    @Test
    public void shouldFindTestcasesRunBadWithoutDefectTicket() {
        StrategyOption strategyOption = new StrategyOption();
        strategyOption.setTagName("RedTCNoDefect");
        strategyOption.setScope("TestCaseResult");
        Map<String, List<?>> stringListMap = underTest.doCheckUp(Arrays.asList(strategyOption), Arrays.asList("qdmabc", "qdmbbb"));
        TestCaseResult defectTestCaseResult = (TestCaseResult) stringListMap.get("RedTCNoDefect").get(0);
        assertEquals("tc002", defectTestCaseResult.getId());
    }

    @Test
    public void shouldFindModulesFullCoverageWithDefectTicket() {
        StrategyOption strategyOption = new StrategyOption();
        strategyOption.setTagName("ModCovFullWithDefect");
        strategyOption.setScope("ModuleResult");
        Map<String, List<?>> stringListMap = underTest.doCheckUp(Arrays.asList(strategyOption), Arrays.asList("qdmabc", "qdmbbb"));
        ModuleResult defectMod = (ModuleResult) stringListMap.get("ModCovFullWithDefect").get(0);
        assertEquals("qdmabc", defectMod.getName());
    }

}
