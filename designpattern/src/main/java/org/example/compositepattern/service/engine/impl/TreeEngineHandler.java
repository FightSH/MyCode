package org.example.compositepattern.service.engine.impl;

import org.example.compositepattern.model.aggreates.TreeRich;
import org.example.compositepattern.model.vo.EngineResult;
import org.example.compositepattern.model.vo.TreeNode;
import org.example.compositepattern.service.engine.EngineBase;

import java.util.Map;

public class TreeEngineHandler extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
