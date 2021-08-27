package org.example.compositepattern.service.logic;

import org.example.compositepattern.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 此接口定义了适配的通用接口和相应的方法。逻辑决策器方法、获取决策值方法
 * 每一个提供决策能力的节点都必须实现此接口，保证统一性
 */
public interface LogicFilter {
    /**
     *
     * @param matterValue    决策值
     * @param treeNodeLinkList    决策节点
     * @return
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     *
     * @param treeId
     * @param userId
     * @param decisionMatter    决策物料
     * @return
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
