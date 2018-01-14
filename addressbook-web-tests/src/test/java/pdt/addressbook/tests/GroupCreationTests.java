package pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test(alwaysRun = true)
    public void testCreateGroup() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        app.group().goToGroupPage();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
