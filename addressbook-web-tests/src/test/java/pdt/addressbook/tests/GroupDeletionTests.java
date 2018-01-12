package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.List;
import java.util.Set;


public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.group().isAnyGroupExists()) {
            GroupData group = new GroupData().withName("test1");
            app.group().create(group);
        }
    }

    @Test(alwaysRun=true)
    public void testDeleteGroup() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
       // app.group().goToGroupPage();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedGroup);
        Assert.assertEquals(before, after);

    }
}
