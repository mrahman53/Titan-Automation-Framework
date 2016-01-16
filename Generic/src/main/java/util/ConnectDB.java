package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> readDataBase() throws Exception {

        try {
// This will load the MySQL driver.
            Class.forName("com.mysql.jdbc.Driver");
// Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/amazon?" +
                    "user=root&password=MyNewPass");
            System.out.println("Database connected");

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
