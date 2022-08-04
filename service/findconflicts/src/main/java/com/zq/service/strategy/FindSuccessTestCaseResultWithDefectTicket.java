package com.zq.service.strategy;


import com.zq.domain.TestCaseResult;
import com.zq.domain.TestResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qz111
 *
 */
/*
 * Input: zu testende Testfälle
 * Output: List von Testfälle, die erfolgreich laufen aber mit Defekt Ticket
 */
public class FindSuccessTestCaseResultWithDefectTicket implements FindConflictsStrategy {

    private final List<TestCaseResult> greenTestCaseResultWithDefect = new ArrayList<>();

    @Override
    public List<? extends TestResult> getConflict(List<? extends TestResult> contentToCheck) {
        if (!contentToCheck.isEmpty() && !(contentToCheck.get(0) instanceof TestCaseResult)) {
            throw new RuntimeException("wrong type of content to test with check green TestCaseResult");
        }
        for (TestCaseResult testCaseResult : (List<TestCaseResult>) contentToCheck) {
            if (testCaseResult.getDefectTicket() != null && testCaseResult.getIsSuccess()) {
                greenTestCaseResultWithDefect.add(testCaseResult);
            }
        }
        return greenTestCaseResultWithDefect;
    }
}
