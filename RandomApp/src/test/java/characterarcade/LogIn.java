package characterarcade;

import CommonApi.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by rrt on 1/2/2016.
 */
public class LogIn extends Base {

    @Test
    public void logIn()throws InterruptedException{
        clickByCss(".user_buttons .login_btn.link_button");
        sleepFor(1);
        WebElement iframe1 = getWebElementByCss("#surf-xdm iframe:nth-child(1)");
        iframeHandle(iframe1);
        WebElement iframe2 = getWebElementByCss("#display-frame");
        iframeHandle(iframe2);
        typeByCss("input#input_username", "hyper-loop");
        sleepFor(1);
        typeByCss("input#input_password", "super-sonic....");
        sleepFor(1);
        clickByCss("#button_submit");
        sleepFor(1);
        goBackToHomeWindow();

    }
}
