package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import pdt.addressbook.models.GroupData;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.name;

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
        click(name("submit"));
    }

    public void fillGroupForm(GroupData group) {
        typeFieldValue(name("group_name"), group.group_name);
        typeFieldValue(name("group_header"), group.group_header);
        typeFieldValue(name("group_footer"), group.group_footer);
    }

    public void initGroup() {
        click(name("new"));
    }

    public void deleteSelectedGroups() {
        click(name("delete"));
    }

    public void selectGroup() {
        // if (wd.findElements(By.name("selected[]")).size() != 0) {
        click(name("selected[]"));
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
        click(name("edit"));
    }

    public void submitGroupModification() {
        click(name("update"));
    }


    public boolean isAnyGroupExists() {
        return !(wd.findElements(By.cssSelector(".group")).size() == 0);

    }


    public int getGroupCount() {
       return wd.findElements(By.name("selected[]")).size();
    }
}