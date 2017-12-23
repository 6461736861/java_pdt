package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


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

}
