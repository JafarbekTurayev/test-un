package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    public static final String dbUser = "postgres"; //user
    public static final String dbPassword = "root123"; //parol
    static String url; //murojaat yo'li
    static String host = "localhost"; //kun.uz //192.168.22.11

    static String dbName = "computer_db";
    static String port = "5432"; //postgres  //oracle //345 //mysql// 123


    //Ulanish un metod kk
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection connection = null;

        url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName; //aynan qaysi yo'lga murojaat qilish
        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(url, dbUser, dbPassword);
        return connection; //failed success
    }
}
