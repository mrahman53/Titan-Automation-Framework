package home;

import CommonApi.Base;
import org.testng.annotations.Test;

/**
 * Created by rrt on 12/26/2015.
 */
public class Search extends Base {

    @Test
    public void test1(){
        clickByCss("#search-button");
        typeByCss("#search-input-field", "politics");
    }
}
