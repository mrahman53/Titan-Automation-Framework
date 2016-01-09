package dataToSearch;

import org.apache.log4j.Level;
import CommonApi.Base;
import util.DataReader;

import java.io.IOException;
import java.util.List;

/**
 * Created by rrt on 1/3/2016.
 */
public class ItemsToBeSearched  {

    //Option 2, supplu data from External source like excel files.
    DataReader dr = new DataReader();
    public String [] getData()throws IOException{
        String path = System.getProperty("user.dir")+"/data/file1.xls";
        String [] st = dr.fileReader(path);
     return st;
    }
}
