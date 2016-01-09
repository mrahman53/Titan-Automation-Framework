package data.reader;

import util.DataReader;

import java.io.IOException;

/**
 * Created by rrt on 1/9/2016.
 */
public class ReadData {

    DataReader dataReader = new DataReader();
    public String [] getActionName()throws IOException {
        String path = System.getProperty("user.dir")+"/data/actionSteps.xls";
        String [] st = dataReader.fileReader(path);
        return st;
    }
    public String [] getData()throws IOException {
        String path = System.getProperty("user.dir")+"/data/searchData.xls";
        String [] st = dataReader.fileReader(path);
        return st;
    }
}
