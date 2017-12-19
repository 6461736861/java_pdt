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

    public void fillGroupForm(GroupData groupData) {

        typeFieldValue(By.name("group_name"), groupData.getGroupName());
        typeFieldValue(By.name("group_header"), groupData.getGroupHeader());
        typeFieldValue(By.name("group_footer"), groupData.getGroupFooter());
    }

    public void initGroup() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        if (wd.findElements(By.name("selected[]")).size() != 0) {
            click(By.name("selected[]"));
        } else
        {
            this.initGroup();
            this.fillGroupForm(new GroupData("create a new", "group if", "it doesnt exist"));
            this.submitGroupCreation();
            click(By.xpath(".//*[@id='content']/div/i/a"));
            click(By.name("selected[]"));

        }
    }


    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
