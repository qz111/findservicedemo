package com.zq.dao;


import com.zq.domain.ModuleResult;
import com.zq.domain.TestCaseResult;

import java.util.List;

/**
 * @author qz111
 */
public interface ModuleResultDao {

    List<ModuleResult> getModule(List<String> moduleName);

    List<TestCaseResult> getAllModuleTC();
}
