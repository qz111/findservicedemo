package com.zq.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qz111
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class ModuleResult extends TestResult {

    private String name;
    private Double coverage;
    private List<String> defectTickets;

    public ModuleResult() {
    }

    public ModuleResult(String id, String name, Double coverage, List<String> defectTickets) {
        super(id);
        this.name = name;
        this.coverage = coverage;
        this.defectTickets = defectTickets;
    }

    @Override
    public String toString() {
        return "ModuleResult{" +
                "name='" + name + '\'' +
                ", coverage=" + coverage +
                ", defectTickets=" + defectTickets +
                '}';
    }
}
