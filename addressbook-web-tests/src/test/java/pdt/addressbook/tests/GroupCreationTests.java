package pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;
import pdt.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.*;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new GroupData().withName("test1").withFooters("footer1").withHeader("header1")});
        list.add(new Object[]{new GroupData().withName("test2").withFooters("footer2").withHeader("header2")});
        list.add(new Object[]{new GroupData().withName("test3").withFooters("footer3").withHeader("header3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testCreateGroup(GroupData group) {
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        app.group().goToGroupPage();
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(alwaysRun = false)
    public void testBadCreateGroup() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        app.group().goToGroupPage();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        //  assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before));
    }
}
