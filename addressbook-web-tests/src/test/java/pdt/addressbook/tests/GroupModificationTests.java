package pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.group().isAnyGroupExists()) {
            GroupData group = new GroupData().withName("test1");
            app.group().create(group);
        }
    }

    @Test(alwaysRun=false)
    public void testGroupModification() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().groupList();
        int index = before.size() - 1;
        GroupData group = new GroupData().
                withId(before.get(index).getId()).withName("test1").withFooters("test2").withHeader("test3");
        app.group().modifyGroup(index, group);
        List<GroupData> after = app.group().groupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}

