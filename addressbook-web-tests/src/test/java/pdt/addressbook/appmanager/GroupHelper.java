package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import pdt.addressbook.models.GroupData;

/**
 * Created by rb on 12/10/17.
 */
public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData group) {
        typeFieldValue(By.name("group_name"), group.group_name);
        typeFieldValue(By.name("group_header"), group.group_header);
        typeFieldValue(By.name("group_footer"), group.group_footer);
    }

    public void initGroup() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        // if (wd.findElements(By.name("selected[]")).size() != 0) {
        click(By.name("selected[]"));
//        } else
//        {
//            this.initGroup();
//            this.fillGroupForm(new GroupData("create a new", "group if", "it doesnt exist"));
//            this.submitGroupCreation();
//            click(By.xpath(".//*[@id='content']/div/i/a"));
//            click(By.name("selected[]"));
//
//        }
    }


    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }


    public boolean isAnyGroupExists() {
       // return !wd.findElement(By.name("selected[]")).getSize().equals(0);
        return wd.findElements(By.name("selected[]")).size() == 0;
    }
}
