package pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;
import pdt.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test(alwaysRun = true)
    public void testCreateGroup() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        app.group().goToGroupPage();
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
