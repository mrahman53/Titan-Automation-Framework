package SearchItems;

import CommonApi.Base;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

/**
 * Created by rrt on 12/26/2015.
 */
public class HomeSearch extends Base {

    @Test
    public void test1()throws InterruptedException{
        //fetch the list of webelemnets from drop down menu and get text form the list
        List<String> text= getTextFromWebElements("#searchDropdownBox option");

        //get each text from the list, then enter each text into input box.
        for(int i=0; i<text.size(); i++){
            typeByCss("#twotabsearchtextbox",text.get(i));
            keysInput("#twotabsearchtextbox");
            clearInput("#twotabsearchtextbox");
            sleepFor(3);
            text= getTextFromWebElements("#searchDropdownBox option");
        }
    }


}
