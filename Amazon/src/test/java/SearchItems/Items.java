package SearchItems;

import CommonApi.Base;
import dataToSearch.ItemsToBeSearched;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_factory.Search;
import util.ConnectDB;

import java.io.IOException;
import java.util.List;

/**
 * Created by rrt on 1/3/2016.
 */
public class Items extends Base {


     @Test
    public void searchUsingExcelFile()throws IOException,InterruptedException{
         //initialize Search page factory
        Search search = PageFactory.initElements(driver,Search.class);
         //Read data from excel file
        ItemsToBeSearched itemsToBeSearched = new ItemsToBeSearched();
        String [] st = itemsToBeSearched.getData();
         for(String data:st) {
             search.searchFor(data);
             sleepFor(2);
             search.clearSearchInput();
         }
    }

    @Test
    public void searchUsingDB()throws Exception,InterruptedException{
        //initialize Search page factory
        Search search = PageFactory.initElements(driver,Search.class);
        //Read Data From Database
        ConnectDB db = new ConnectDB();
        List<String> st = db.readDataBase();
        for(String data:st) {
            search.searchFor(data);
            sleepFor(2);
            search.clearSearchInput();
        }
    }




     //One Data Driven Option to supply data from Data Provider
    @DataProvider(name = "items")
    public Object[][] createData(){
        return new Object[][]{
                {"Books"} ,
                {"Baby"} ,
                {"Computer"},
        };
    }

    @Test(dataProvider = "items")
    public void searchUsingDataProvider(String data)throws InterruptedException{
        //initialize Search page factory
        Search search = PageFactory.initElements(driver,Search.class);
            search.searchFor(data);
            sleepFor(2);
            search.clearSearchInput();
    }
}
