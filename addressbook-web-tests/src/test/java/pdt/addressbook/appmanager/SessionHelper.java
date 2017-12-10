package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by rb on 12/10/17.
 */
public class SessionHelper extends BaseHelper {
    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        typeGroupName(By.name("user"),username);
        typeGroupName(By.name("pass"),password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

}
