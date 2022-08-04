package com.zq.service.find;


import com.zq.domain.StrategyOption;

import java.util.List;
import java.util.Map;

/**
 * @author qz111
 */

public interface FindConflictsService {

    Map<String, List<?>> doCheckUp(List<StrategyOption> tags, List<String> moduleNames);

}
