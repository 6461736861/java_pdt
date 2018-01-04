package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.UUID;

public class GroupCreationTests extends TestBase {

    @Test
    public void testCreateGroup() {
        GroupData group = new GroupData();
        group.group_name = String.format("Group name%s", UUID.randomUUID());
        group.group_footer = String.format("Footer%s", UUID.randomUUID());
        group.group_header = String.format("Header%s", UUID.randomUUID());
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroup();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "A new group has been entered into the address book.\n" + "return to the group page"));

        app.getGroupHelper().returnToGroupPage();
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before+1);
    }



}
