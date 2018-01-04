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

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        GroupData group = new GroupData();

        app.getNavigationHelper().goToGroupPage();
        //writing the amount of groups before modification action
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //selecting the fist group in the list of groups
        app.getGroupHelper().selectGroup(1);
        app.getGroupHelper().initGroupModification();
        //changing the group name to some other name plus random amount of characters
        group.group_name = String.format("MODIFIED%s", UUID.randomUUID());
        app.getGroupHelper().fillGroupForm(group);

        app.getGroupHelper().submitGroupModification();
        //checking that a message that group was changed is shown, wait 5 seconds to appear
        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Group record has been updated.\n" + "return to the group page"));

        app.getGroupHelper().returnToGroupPage();
        //checking that use was redirected to the group page
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());
    }

    @BeforeMethod
    public void createGroupIfDoesNotExist() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isAnyGroupExists()) {
            GroupData group = new GroupData();
            group.group_name = String.format("Group name%s", UUID.randomUUID());
            group.group_footer = String.format("Footer%s", UUID.randomUUID());
            group.group_header = String.format("Header%s", UUID.randomUUID());
            app.getGroupHelper().initGroup();
            app.getGroupHelper().fillGroupForm(group);
            app.getGroupHelper().submitGroupCreation();
        }
    }
}

