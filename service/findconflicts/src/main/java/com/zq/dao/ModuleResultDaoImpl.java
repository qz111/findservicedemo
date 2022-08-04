package com.zq.dao;


import com.zq.domain.ModuleResult;
import com.zq.domain.TestCaseResult;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author qz111
 */
/*
 * Eine vereinfachte Mockumsetzung für die Datenzugriff aus Datenbank.
 * ModuleResult1 hat eine Defekt Ticket obwohl es 100% abgedeckt ist.(Konflikt entsteht)
 * ModuleResult2 ist 100% abgedekt und hat keine Defekt Ticket.
 * TestCaseResult1 läuft erfolgreich aber es gibt Defekt Ticket. (Konflikt entsteht)
 * TestCaseResult2 läuft nicht erfolgreich aber es gibt keine Defekt Ticket. (Konflikt entsteht)
 * TestCaseResult3 ist in Ordnung.
 * */
@Repository
public class ModuleResultDaoImpl implements ModuleResultDao {

    @Override
    public List<ModuleResult> getModule(List<String> moduleName) {
        ModuleResult moduleResult1 = new ModuleResult();
        moduleResult1.setName("qdmabc");
        moduleResult1.setDefectTickets(Arrays.asList("EFSA-1111", "EFSA-123"));
        moduleResult1.setCoverage(100.0);
        ModuleResult moduleResult2 = new ModuleResult();
        moduleResult2.setName("qdmbbb");
        moduleResult2.setCoverage(100.0);
        return Arrays.asList(moduleResult1, moduleResult2);
    }

    @Override
    public List<TestCaseResult> getAllModuleTC() {
        TestCaseResult testCaseResult1 = new TestCaseResult();
        TestCaseResult testCaseResult2 = new TestCaseResult();
        TestCaseResult testCaseResult3 = new TestCaseResult();
        testCaseResult1.setId("tc001");
        testCaseResult1.setDefectTicket("EFSA-123");
        testCaseResult1.setIsSuccess(Boolean.TRUE);
        testCaseResult2.setId("tc002");
        testCaseResult2.setIsSuccess(Boolean.FALSE);
        testCaseResult3.setId("tc003");
        testCaseResult3.setIsSuccess(Boolean.TRUE);
        return Arrays.asList(testCaseResult1, testCaseResult2, testCaseResult3);
    }
}
