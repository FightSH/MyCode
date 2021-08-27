package org.example.compositepattern.service.engine;

import org.example.compositepattern.model.aggreates.TreeRich;
import org.example.compositepattern.model.vo.EngineResult;

import java.util.Map;

/**
 * 决策引擎接口
 */
public interface IEngine {
    // 统一的处理操作，方便后续扩展
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
