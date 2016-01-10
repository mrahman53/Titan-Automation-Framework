package search.data;

import data.reader.ReadData;
import data.reader.TestAction;
import org.testng.annotations.Test;
import CommonApi.Base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrt on 1/9/2016.
 */
public class SearchNews extends Base {
    ReadData readData = new ReadData();
    List<String> list = new ArrayList<String>();
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

    public List<String> getNewsData()throws Exception{
       String [] st = readData.getData();
        String data = "";
        for(String fetch:st){
           list.add(fetch);
        }
        return list;
    }
    //action steps method
    public void ClickOnSearch() {
        clickByCss("#search-button");
    }
    public void TypeOnSearch()throws Exception{
        for(int i=0; i<list.size(); i++) {
            typeByCss("#search-input-field", getNewsData().get(i));
        }
    }

}
