package com.zq.service.strategy;

import com.zq.domain.TestResult;

import java.util.List;

/**
 * @author qz111
 */
/*
 * Interface für die Überprüfungsstrategien. Es gibt 3 Umsetzung.
 * 1. FindSuccessTestCaseResultWithDefectTicket: Alle Testfälle werden überprüft, um die TCs mit erfolgreiche Ergebnis aber auch mit Defekt Ticket zu finden.
 * 2. FindFailedTestCaseResultsWithoutDefectTicket: Alle Testfälle werden überprüft, um die scheiterte TCs ohne Defekt Ticket zu finden.
 * 3. FindModuleResultsFullCoverageWithDefectTicket: Alle angegebene ModuleResult werden überprüft, um die vollständig abgedekte ModuleResult mit Defekt Ticket zu finden.
 * */

public interface FindConflictsStrategy {

    List<? extends TestResult> getConflict(List<? extends TestResult> contentToCheck);

}
