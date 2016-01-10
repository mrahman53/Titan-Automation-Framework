package util;

import java.io.IOException;

/**
 * Created by mrahman on 1/9/16.
 */
public class DBConnectTest {

    static ConnectDB db = null;
    public static void main(String[] args)throws Exception {

        db = new ConnectDB();
        db.readDataBase();


    }
}
