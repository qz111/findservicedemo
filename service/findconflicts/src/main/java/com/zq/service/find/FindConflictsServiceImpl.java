package com.zq.service.find;


import com.zq.domain.StrategyOption;
import com.zq.domain.TestResult;
import com.zq.service.strategy.FindConflictsStrategy;
import com.zq.service.strategy.TestResultsFindStrategyFactory;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qz111
 */
/*
 * FindService Umsetzung um alle Auffälligkeit in TCs und Modulen zu finden
 * Input:
 *   List<StrategyOption> tags: List von Überprüfungsprinzip um passende Strategie zu finden
 *   List<String> moduleNames: die zu überprüfende Modulen
 * Ouput:
 *   Map mit key (Konfliktgrund) und value (List von betroffenen TCs oder Modulen)
 * */
@Data
@Service
public class FindConflictsServiceImpl implements FindConflictsService {

    private FindConflictsStrategy findConflictsStrategy;
    private List<? extends TestResult> contentToCheck;

    public FindConflictsServiceImpl() {
    }

    @Override
    public Map<String, List<?>> doCheckUp(List<StrategyOption> tags, List<String> moduleNames) {
        Map<String, List<?>> defectsMap = new HashMap<>();
        for (StrategyOption tag : tags) {
            findConflictsStrategy = TestResultsFindStrategyFactory.getStrategy(tag);
            contentToCheck = TestResultsFindStrategyFactory.getContent(tag, moduleNames);
            defectsMap.put(tag.getTagName(), findConflictsStrategy.getConflict(contentToCheck));
        }
        return defectsMap;
    }
}
