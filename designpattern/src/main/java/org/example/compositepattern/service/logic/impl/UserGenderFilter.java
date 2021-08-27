package org.example.compositepattern.service.logic.impl;

import org.example.compositepattern.service.logic.BasicLogic;

import java.util.Map;

/**
 * 性别节点
 */
public class UserGenderFilter extends BasicLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
