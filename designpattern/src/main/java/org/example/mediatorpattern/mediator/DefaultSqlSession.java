package org.example.mediatorpattern.mediator;


import java.lang.reflect.Method;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class DefaultSqlSession implements SqlSession {
    private Connection connection;

    private Map<String, XNode> mapperElement;

    public DefaultSqlSession(Connection connection, Map<String, XNode> mapperElement) {
        this.connection = connection;
        this.mapperElement = mapperElement;
    }

    @Override
    public <T> T selectOne(String statement) {

        try {
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> objects = resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
            return objects.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return null;
    }

    @Override
    public <T> T selectList(String statement) {
        XNode xNode = mapperElement.get(statement);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T selectList(String statement, Object parameter) {
        return null;
    }

    private <T> List<T> resultSet2Obj(ResultSet resultSet, Class<?> clazz) {
        ArrayList<T> list = new ArrayList<>();
        try {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                T obj = (T) clazz.getDeclaredConstructor().newInstance();
                for (int i = 1; i < columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    String columnName = metaData.getColumnName(i);
                    String setMethod = "set" + columnName.substring(0, 1).toUpperCase(Locale.ROOT) + columnName.substring(1);
                    Method method;
                    if (value instanceof Timestamp) {
                        method = clazz.getMethod(setMethod, Date.class);
                    } else {
                        method = clazz.getMethod(setMethod, value.getClass());
                    }
                    method.invoke(obj, value);
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void close() {
        if (null == connection) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
