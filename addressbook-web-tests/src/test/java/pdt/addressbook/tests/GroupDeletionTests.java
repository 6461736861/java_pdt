package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.List;


public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.group().isAnyGroupExists()) {
            GroupData group = new GroupData().withName("test1");
            app.group().create(group);
        }
    }

    @Test
    public void testDeleteGroup() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().groupList();
        app.group().selectGroup(before.size() - 1);
        app.group().deleteSelected();
        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Group has been removed.\n" + "return to the group page"));

        app.group().goToGroupPage();
        webDriverWait.withMessage("User is not redirected to the group page");
        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
        List<GroupData> after = app.group().groupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
