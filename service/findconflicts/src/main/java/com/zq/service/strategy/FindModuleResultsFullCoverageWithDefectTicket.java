package com.zq.service.strategy;


import com.zq.domain.ModuleResult;
import com.zq.domain.TestResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qz111
 */
/*
 * Input: zu testende Modulen
 * Output: List von Modulen, die vollständig abgedekt werden aber mit Defekt Ticket
 * */
public class FindModuleResultsFullCoverageWithDefectTicket implements FindConflictsStrategy {

    public static final double FULL_COVERAGE = 100.0;
    private final List<ModuleResult> ModCovFullWithDefect = new ArrayList<>();

    @Override
    public List<? extends TestResult> getConflict(List<? extends TestResult> contentToCheck) {
        if (!contentToCheck.isEmpty() && !(contentToCheck.get(0) instanceof ModuleResult)) {
            throw new RuntimeException("wrong type of content to test with check full cov module");
        }
        for (ModuleResult moduleResult : (List<ModuleResult>) contentToCheck) {
            if (moduleResult.getDefectTickets() != null && !moduleResult.getDefectTickets().isEmpty() && moduleResult.getCoverage() == FULL_COVERAGE) {
                ModCovFullWithDefect.add(moduleResult);
            }
        }
        return ModCovFullWithDefect;
    }
}
