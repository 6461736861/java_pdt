package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rb on 12/10/17.
 */
public class NavigationHelper extends BaseHelper {
    public NavigationHelper(WebDriver wd) {
       super(wd);
    }
    public void groupPage() {
        click(By.linkText("groups"));
    }

}
