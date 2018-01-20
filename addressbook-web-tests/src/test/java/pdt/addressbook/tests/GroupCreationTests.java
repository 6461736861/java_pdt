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
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(alwaysRun = true)
    public void testBadCreateGroup() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        app.group().goToGroupPage();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
      //  assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before));
    }
}
