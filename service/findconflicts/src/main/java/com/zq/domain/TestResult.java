package com.zq.domain;

import lombok.Data;

/**
 * @author qz111
 * 2
 */
@Data
public abstract class TestResult {

    private String id;

    public TestResult() {
    }

    public TestResult(String id) {
        this.id = id;
    }
}
