package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.UUID;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        GroupData group = new GroupData();
        navigationHelper.goToGroupPage();
        groupHelper.selectGroup();
        groupHelper.initGroupModification();
        groupHelper.fillGroupForm(group);
        
        groupHelper.submitGroupModification();
        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Group record has been updated.\n" + "return to the group page"));

        groupHelper.returnToGroupPage();
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
    }

    @BeforeMethod
    public void createGroupIfDoesNotExist() {
        navigationHelper.goToGroupPage();
        if (!groupHelper.isAnyGroupExists()) {
            GroupData group = new GroupData();
            group.group_name = String.format("Group name%s", UUID.randomUUID());
            group.group_footer = String.format("Footer%s", UUID.randomUUID());
            group.group_header = String.format("Header%s", UUID.randomUUID());
            groupHelper.initGroup();
            groupHelper.fillGroupForm(group);
            groupHelper.submitGroupCreation();
        }
    }
}

