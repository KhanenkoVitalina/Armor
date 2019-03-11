package model.database;

import org.apache.commons.dbcp.*;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConfigConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/knightsdata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Vitalina1!";

    private GenericObjectPool connectionPool = null;

    public PoolingDataSource setUp() throws Exception {

        Class.forName(ConfigConnection.DRIVER).newInstance();

        connectionPool = new GenericObjectPool();
        connectionPool.setMaxActive(10);

        ConnectionFactory cf = new DriverManagerConnectionFactory(
                ConfigConnection.URL,
                ConfigConnection.USERNAME,
                ConfigConnection.PASSWORD);


        PoolableConnectionFactory pcf =
                new PoolableConnectionFactory(cf, connectionPool,
                        null, null, false, true);
        return new PoolingDataSource(connectionPool);
    }

}


