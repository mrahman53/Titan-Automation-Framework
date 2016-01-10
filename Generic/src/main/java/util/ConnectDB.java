package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< Updated upstream
 + * Created by mrahman on 12/22/15.
 + *
 + * Connect to DB
 + */
=======
 * Created by mrahman on 1/7/15.
 *
 * Connect to DB
 */
>>>>>>> Stashed changes
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
       String userName = resultSet.getString("username");
          String passwd = resultSet.getString("passwd");
              String email = resultSet.getString("email");
            System.out.println("Password: " + passwd);
               System.out.println("Email: " + email);
        }

       }

   private void close() {
         try {
                  if (resultSet != null) {
                         resultSet.close();
                     }

<<<<<<< Updated upstream
                     if (statement != null) {
                        statement.close();
                    }
=======
    //List of fields.
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    List<String> list = new ArrayList<String>();
    String url = "jdbc:mysql://localhost/userLogin";
    String userName = "root";
    String passWord = "MyNewPassword";

    //Connect to Database
    public void dbConnect() throws Exception{
//        int myResult = st.executeUpdate("CREATE DATABASE IF NOT EXISTS mydb2");
//        System.out.println("Database created !");

        // This will load the MySQL driver.
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager.getConnection(url, userName, passWord);
        System.out.println("Database connected");

    }
    //Get the Tracking or mobile lists
    public List<String> readDataBase() throws Exception {
        try {
            dbConnect();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("Select * from SubmitTrackingInformation");
            getResultSetData(resultSet);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return list;
    }
    //Post the Tracking information
    public void insertIntoSubmitTrackingInformation(String tn) throws Exception {
        try {
            dbConnect();

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            statement.executeUpdate("Insert into SubmitTrackingInformation(ClientTrackingOrMobilecontactNo)" + "Values('tn')");
        }catch (Exception e) {
            throw e;
        }finally{
            close();
        }
    }
    /**
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private List<String> getResultSetData(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            String tnum = resultSet.getString("ClientTrackingOrMobilecontactNo");
            list.add("ClientInformation:" + tnum);
        }
        return list;
    }

    /**
     *
     * @param resultSet
     * @throws SQLException
     */
    private void writeResultSetToConsole(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            String tnum = resultSet.getString("ClientTrackingOrMobilecontactNo");
            System.out.println("ClientInformation:" + tnum);

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
>>>>>>> Stashed changes

                        if (connect != null) {
                         connect.close();
                      }
                 } catch (Exception e) {

<<<<<<< Updated upstream
                   }
       }
   }
=======
}


>>>>>>> Stashed changes
