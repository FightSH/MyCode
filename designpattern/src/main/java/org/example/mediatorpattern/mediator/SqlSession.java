package org.example.mediatorpattern.mediator;

public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> T selectList(String statement);

    <T> T selectList(String statement, Object parameter);

    void close();


}