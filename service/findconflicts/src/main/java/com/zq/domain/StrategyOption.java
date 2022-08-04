package com.zq.domain;

import lombok.Data;

/**
 * @author qz111
 */
/*
 * Datenformat aus Frontend
 * scope: was wird überprüft
 * tagName: welche Konflikt ist zu finden
 * z.B. StrategyOption{scope:"TestCaseResult", tagName:"GreenTCWithDefect"}
 * Alle Testfälle werden überprüft, um die grüne TCs mit Defekt Ticket zu finden.
 * */
@Data
public class StrategyOption {

    private String scope;
    private String tagName;

    public StrategyOption() {
    }
}
