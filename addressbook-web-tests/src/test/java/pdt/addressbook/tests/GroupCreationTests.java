package pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;
import pdt.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.*;
import java.util.*;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader("scr/test/resources/groups.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData().withName(split[0]).withFooters(split[1]).withHeader(split[2])});
          //  list.add(new Object[]{new GroupData().withName(split[0]).withFooters(split[1]).withHeader(split[2])});
            line = reader.readLine();
        }
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
