package w3schools;

import CommonApi.Base;
import org.testng.annotations.Test;

/**
 * Created by rrt on 1/2/2016.
 */
public class TableData extends Base {

    @Test
    public void getTableData(){
        for(int i=1; i<=6; i++) {
            String text = getTextByCss(".table-responsive tbody tr:nth-child("+i+")");
            System.out.println(text);
        }
    }
}
