package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pdt.addressbook.models.GroupData;

/**
 * Created by rb on 12/10/17.
 */
public class GroupHelper extends BaseHelper {

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {

        typeGroupName(By.name("group_name"), groupData.getGroupName());
        typeGroupName(By.name("group_header"), groupData.getGroupHeader());
        typeGroupName(By.name("group_footer"), groupData.getGroupFooter());
    }

    public void initGroup() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

}
