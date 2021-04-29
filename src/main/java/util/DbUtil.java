package util;

import config.DbConfig;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {


    static Statement statement;
    static List<Product> productList = new ArrayList<Product>();

    public static void selectProduct(String sql) throws SQLException, ClassNotFoundException {

        Connection connection = DbConfig.getConnection(); //ulanish un tunnnel

        statement = connection.createStatement(); //mashina sql query yurishi un

        ResultSet resultSet = statement.executeQuery(sql);//zaprosni bajartiradi!

//        System.out.println(resultSet);

        while (resultSet.next()) {
            //bitta row
//            System.out.println(resultSet.getString("maker")); //ustunni nomi bn o'qish
//            System.out.println(resultSet.getString(1)); //ustunni indexi bn o'qish
            Product product = new Product();
            product.setMaker(resultSet.getString(1));
            product.setModel(resultSet.getString(2));
            product.setType(resultSet.getString(3));

            productList.add(product);

        }

        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + " = > " + productList.get(i));
        }
//        System.out.println(productList);
    }

    public static void callFunction(String sql) throws SQLException, ClassNotFoundException {
        Connection connection = DbConfig.getConnection();

        CallableStatement callableStatement = connection.prepareCall(sql);

        callableStatement.setInt(1, 5); //x
        callableStatement.setInt(2, 10); //y
        callableStatement.setInt(3, 1); //z


        callableStatement.registerOutParameter(2, Types.INTEGER); //qaytadigan javob
        callableStatement.executeUpdate(); //bajarib keldi


        System.out.println(callableStatement.getInt(2));

    }

    public static void addPayType(String sql, String name) throws SQLException, ClassNotFoundException {
        Connection connection = DbConfig.getConnection();

        CallableStatement callableStatement = connection.prepareCall(sql);

        callableStatement.setString(1, name);


        callableStatement.registerOutParameter(2, Types.BOOLEAN);
        callableStatement.registerOutParameter(3, Types.VARCHAR);

        callableStatement.executeUpdate(); //ishga tushiradi

        System.out.println(callableStatement.getBoolean(2));
        System.out.println(callableStatement.getString(3));

    }


    public static void test(String sql) throws SQLException, ClassNotFoundException {
        Connection connection = DbConfig.getConnection();


        statement = connection.createStatement();

        if (sql.toLowerCase().contains("insert")) {
            int i = statement.executeUpdate(sql); // 0 5

            System.out.println(i + " ta malumot qo'shildi!");
        } else if (sql.toLowerCase().contains("update")) {

            int i = statement.executeUpdate(sql); //0 2

            System.out.println(i + " ta malumot o'zgartirildi!");

        } else if (sql.toLowerCase().contains("delete")) {
            int i = statement.executeUpdate(sql);
            System.out.println(i + " ta malumot o'chirildi!");
        } else {
            System.out.println("Xatolik!");
        }

    }

}
