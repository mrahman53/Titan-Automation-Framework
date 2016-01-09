package SearchItems;

import CommonApi.Base;
import dataToSearch.ItemsToBeSearched;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_factory.Search;

import java.io.IOException;

/**
 * Created by rrt on 1/3/2016.
 */
public class Items extends Base {

     @Test
    public void search()throws IOException,InterruptedException{
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




     //One Data Driven Option to supply data from Data Provider
    @DataProvider(name = "items")
    public Object[][] createData(){
        return new Object[][]{
                {"Books"} ,
                {"Baby"} ,
                {"Computer"},
        };
    }
}
