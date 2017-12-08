package pdt.addressbook;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroup() {
        goToGroupPage();
        initGroup();
        fillGroupForm(new GroupData("test", "test1", "test2"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
