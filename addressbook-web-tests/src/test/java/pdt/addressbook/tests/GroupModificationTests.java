package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        navigationHelper.goToGroupPage();
        groupHelper.selectGroup();
        groupHelper.initGroupModification();
        groupHelper.fillGroupForm(new GroupData("EDITED_test", "EDITED_test2", "EDITED_test3"));
        
        groupHelper.submitGroupModification();
        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Group record has been updated.\n" + "return to the group page"));

        groupHelper.returnToGroupPage();
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
    }
}

