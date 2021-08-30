package org.example.mediatorpattern.dao;

import org.example.mediatorpattern.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
