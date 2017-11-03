package com.csse.db.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
	private BlockingQueue<Connection> pool;
    private int maxPoolSize;
    private int initialPoolSize;
    private int currentPoolSize;

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public ConnectionPool(int maxPoolSize, int initialPoolSize, String url, String username,
                          String password, String driverClassName) throws ClassNotFoundException, SQLException {

        if( (initialPoolSize > maxPoolSize) || initialPoolSize<1 || maxPoolSize <1 ) {
            throw new IllegalArgumentException("Invalid pool size parameters");
        }

        // default max pool size to 10
        this.maxPoolSize = maxPoolSize>0 ? maxPoolSize : 10;
        this.initialPoolSize = initialPoolSize;
        this.dbUrl = url;
        this.dbUser = username;
        this.dbPassword = password;
        this.pool = new LinkedBlockingQueue<Connection>(maxPoolSize);

        initPooledConnections(driverClassName);

        /*if(pool.size() != initialPoolSize) {
            
        }*/

    }

    private void initPooledConnections(String driverClassName)
            throws ClassNotFoundException, SQLException {

        Class.forName(driverClassName);
        for(int i=0; i<initialPoolSize; i++) {
            openPoolConnection();
        }
    }

    private synchronized void openPoolConnection() throws SQLException {
        if(currentPoolSize == maxPoolSize) { 
        	return;
        }
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        pool.offer(conn);
        currentPoolSize++;

    }

    public Connection getConnectionFromPool() throws InterruptedException, SQLException {
        if(currentPoolSize < maxPoolSize) { 
        	openPoolConnection();
        }
        return pool.take();
    }
 
}
