package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.GroupData;

import java.util.UUID;

public class GroupCreationTests extends TestBase {

    @Test
    public void testCreateGroup() {
        GroupData group = new GroupData();
        navigationHelper.goToGroupPage();
        groupHelper.initGroup();
        groupHelper.fillGroupForm(group);
        groupHelper.submitGroupCreation();

        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "A new group has been entered into the address book.\n" + "return to the group page"));

        groupHelper.returnToGroupPage();
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
    }

}
