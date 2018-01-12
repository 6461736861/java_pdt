package pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.group().isAnyGroupExists()) {
            GroupData group = new GroupData().withName("test1");
            app.group().create(group);
        }
    }

    @Test(alwaysRun=true)
    public void testGroupModification() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().
                withId(modifiedGroup.getId()).withName("test1").withFooters("test2").withHeader("test3");
        app.group().modifyGroup(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size(), after.size());
        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}

