package search.data;

import data.reader.ReadData;
import data.reader.TestAction;
import org.testng.annotations.Test;
import CommonApi.Base;

/**
 * Created by rrt on 1/9/2016.
 */
public class SearchNews extends Base {
    ReadData readData = new ReadData();
    @Test
    public void searchNewsByKey()throws Exception{
        String [] news = readData.getActionName();
        for(String item:news){
            if(item!=null) {
                chooseAction(item);
            }
        }
    }

    public void chooseAction(String action)throws Exception {
        switch(action){
            case "ClickOnSearch": ClickOnSearch();
                break;
            case "TypeOnSearch": TypeOnSearch();
                break;
            default:System.out.println("Invalid Input");
                break;
        }
    }

    public String getNewsData()throws Exception{
       String [] st = readData.getData();
        String data = "";
        for(String fetch:st){
           data = fetch;
        }
        return data;
    }
    //action steps method
    public void ClickOnSearch() {
        clickByCss("#search-button");
    }
    public void TypeOnSearch()throws Exception{
        typeByCss("#search-input-field", getNewsData());
    }

}
