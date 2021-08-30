package org.example.proxypattern;

public interface IUserDao {

    @Select("select userName from user where id = #{id}")
    String queryUserInfo(String id);

}
