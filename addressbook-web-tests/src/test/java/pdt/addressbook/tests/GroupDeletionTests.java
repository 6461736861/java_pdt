package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.UUID;

import static org.openqa.selenium.By.name;


public class GroupDeletionTests extends TestBase {
    @Test
    public void testDeleteGroup() {
        navigationHelper.goToGroupPage();
        groupHelper.selectGroup();
        groupHelper.deleteSelectedGroups();
        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Group has been removed.\n" + "return to the group page"));

        groupHelper.returnToGroupPage();
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
    }

    @BeforeMethod
    public void createGroupIfDoesNotExist() {
        navigationHelper.goToGroupPage();
        //  if (!groupHelper.isElementPresent(name("selected[]"))) {
        if(!groupHelper.isAnyGroupExists()){

            groupHelper.initGroup();
            GroupData group = new GroupData();
            group.group_name = String.format("Group name%s", UUID.randomUUID());
            group.group_footer = String.format("Footer%s", UUID.randomUUID());
            group.group_header = String.format("Header%s", UUID.randomUUID());


            groupHelper.fillGroupForm(group);
            groupHelper.submitGroupCreation();
        }
    }

}
