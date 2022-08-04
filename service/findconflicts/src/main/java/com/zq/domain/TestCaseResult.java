package com.zq.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * @author qz111
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class TestCaseResult extends TestResult {

    private String defectTicket;
    private Boolean isSuccess;

    public TestCaseResult() {
    }

    public TestCaseResult(String id, String defectTicket, Boolean isSuccess) {
        super(id);
        this.defectTicket = defectTicket;
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "TestCaseResult{" +
                "defectTicket='" + defectTicket + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
