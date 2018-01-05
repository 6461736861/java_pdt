package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.List;
import java.util.UUID;

import static org.openqa.selenium.By.name;


public class GroupDeletionTests extends TestBase {
    @Test
    public void testDeleteGroup() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //selecting the last group to remove
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Group has been removed.\n" + "return to the group page"));

        app.getGroupHelper().returnToGroupPage();
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        //check that lists before and after are equals
        Assert.assertEquals(before, after);

    }

    @BeforeMethod
    public void createGroupIfDoesNotExist() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isAnyGroupExists()) {

            app.getGroupHelper().initGroup();
            GroupData group = new GroupData("test1", "test2", "test3");
            app.getGroupHelper().fillGroupForm(group);
            app.getGroupHelper().submitGroupCreation();
        }
    }

}
