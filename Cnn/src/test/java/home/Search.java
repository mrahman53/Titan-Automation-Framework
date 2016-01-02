package home;

import CommonApi.Base;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import search.data.DataToSearch;

/**
 * Created by rrt on 12/26/2015.
 */
public class Search extends Base {

    @DataProvider(name = "items")
    public Object[][] createData(){
        return new Object[][]{
                {"Politics"} ,
                {"Money"} ,
                {"Tech"},
        };
    }
    @Test(dataProvider = "items")
    public void test1(String data){
        clickByCss("#search-button");
        typeByCss("#search-input-field", data);
    }
}
