package pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;
import pdt.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
      //  if (!app.group().isAnyGroupExists()) {
       if (app.group().all().size()==0) {
            GroupData group = new GroupData().withName("test1");
            app.group().create(group);
        }
    }

    @Test(alwaysRun = true)
    public void testDeleteGroup() {
        app.goTo().groupPage();
//        Set<GroupData> before = app.group().all();
//        GroupData deletedGroup = before.iterator().next();
//        app.group().delete(deletedGroup);
//       // app.group().goToGroupPage();
//        Set<GroupData> after = app.group().all();
//        Assert.assertEquals(after.size(), before.size() - 1);
//        before.remove(deletedGroup);
//        Assert.assertEquals(before, after);
        Groups before = app.group().all();//.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedGroup)));

    }
}
