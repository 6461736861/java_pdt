package pdt.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;
import pdt.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GroupCreationTests extends TestBase {

    org.slf4j.Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader
                ("/Users/rb/java_pdt/addressbook-web-tests/src/test/resources/groups.json"));
        String json = "";
        Gson gson = new Gson();
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {}.getType());
        return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }


    @Test(dataProvider = "validGroups")
    public void testCreateGroup(GroupData group) {
        logger.info("start testCreateGroup");
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        app.group().goToGroupPage();
        logger.info("finishing testCreateGroup");
       // assertThat(app.group().count(), equalTo(before.size() + 1));
       // Groups after = app.group().all();
      //  assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
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
