package pdt.addressbook.tests;

import org.testng.annotations.Test;


public class DeleteGroupTest extends TestBase {
    @Test
    public void testDeleteGroup() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
