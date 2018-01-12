package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test(alwaysRun=true)
    public void testCreateGroup() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        app.group().goToGroupPage();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);

//        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
//        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "A new group has been entered into the address book.\n" + "return to the group page"));
//
//
//        webDriverWait.withMessage("User is not redirected to the group page");
//        webDriverWait.until(ExpectedConditions.urlContains("group.php"));
//
//
//
//        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()   );

    }
}
