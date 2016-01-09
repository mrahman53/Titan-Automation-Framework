package data.reader;

import CommonApi.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by rrt on 1/9/2016.
 */
public class TestAction extends Base{

    public void ClickOnSearch() {
        clickByCss("#search-button");
    }
    public void TypeOnSearch(){
        typeByCss("#search-input-field", "tech");
    }
}
