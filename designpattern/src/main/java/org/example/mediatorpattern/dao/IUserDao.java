package org.example.mediatorpattern.dao;

import org.example.mediatorpattern.po.User;

public interface IUserDao {

     User queryUserInfoById(Long id);

}