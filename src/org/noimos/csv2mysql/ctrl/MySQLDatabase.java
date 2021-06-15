package org.noimos.csv2mysql.ctrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLDatabase {

    private final static String driver = "com.mysql.cj.jdbc.Driver"; // MySQL Driver
    private static String database; // MySQL Database name
    private static String url; // MySQL Database connection URL
    private static String user; // MySQL server username
    private static String password; // MySQL server password of the specific user
    private static String hostname; // Host of the MySQL server
    private static String port; // Port of the MySQL service
    private static MySQLDatabase mysql; // Singleton Object of this class
    public static java.sql.Connection connection; // MySQL connection object
    private static String encoding = "?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false"; // Custom encodings for connection URL

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String aDatabase) {
        database = aDatabase;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String aUser) {
        user = aUser;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    public static String getHostname() {
        return hostname;
    }

    public static void setHostname(String aHostname) {
        hostname = aHostname;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String aPort) {
        port = aPort;
    }

    private MySQLDatabase(String hostname, String port, String user, String password, String database) {
        this.hostname = hostname;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    // get the current MySQL database
    public static synchronized MySQLDatabase getDb(String hostname, String port, String user, String password, String database) throws Exception {
        mysql = new MySQLDatabase(hostname, port, user, password, database);
        return mysql;
    }

    // get the current MySQL database
    public static synchronized MySQLDatabase getDb() throws Exception {
        if (mysql == null) {
            mysql = new MySQLDatabase(hostname, port, user, password, database);
        }
        return mysql;
    }

    // get the current MySQL database connection
    public static java.sql.Connection connection() throws Exception {
        if (getDatabase() == null) { // when a database name is not given
            url = "jdbc:mysql://" + getHostname() + ":" + getPort() + encoding;
        } else { // when a database name is given
            url = "jdbc:mysql://" + getHostname() + ":" + getPort() + "/" + getDatabase() + encoding;
        }
        Class.forName(driver);
        Connection connection1 = (java.sql.Connection) DriverManager.getConnection(url, getUser(), getPassword());
        connection1.setAutoCommit(false);
        return connection1;
    }

    // getting data from the database without changing them
    public static ResultSet getData(java.sql.Connection connection, Statement statement, String sqlQuery) throws Exception {
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        return resultSet;
    }

    // changing the data inside the database
    public static int setData(java.sql.Connection connection, Statement statement, String sqlQuery) throws Exception {
        return statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
    }
}
