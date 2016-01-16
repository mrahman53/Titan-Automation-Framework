package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 + * Created by mrahman on 12/22/15.
 + *
 + * Connect to DB
 + */
public class ConnectDB {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    List<String> list = new ArrayList<String>();

    public static Properties loadPropertiesFile()throws Exception{
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("Generic/lib/MySQL.properties");
        prop.load(ism);
        ism.close();

        return prop;
    }

    //Connect to Database
    public void dbConnect() throws Exception{
        Properties prop = loadPropertiesFile();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String passWord = prop.getProperty("MYSQLJDBC.passWord");
        // This will load the MySQL driver.
        Class.forName(driverClass);
        // Setup the connection with the DB
        connect = DriverManager.getConnection(url, userName, passWord);
        System.out.println("Database connected");

    }

    public List<String> readDataBase() throws Exception {

        try {

            dbConnect();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from DataToBeSearched");
            getResultSetData(resultSet);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return list;
    }
    public void queryDatabase(){

    }

    private List<String> getResultSetData(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            String itemName = resultSet.getString("item_name");

            list.add(itemName);

        }

        return list;
    }
    private void writeResultSetToConsole(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String itemName = resultSet.getString("item_name");
            System.out.println("item name: " + itemName);
        }

    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
