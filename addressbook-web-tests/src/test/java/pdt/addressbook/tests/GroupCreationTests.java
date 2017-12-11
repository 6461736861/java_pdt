package pdt.addressbook.tests;

import org.testng.annotations.Test;
import pdt.addressbook.models.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testCreateGroup() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("test", "test1", "test2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
