package pdt.addressbook;

import org.openqa.selenium.*;
import org.testng.annotations.Test;


public class DeleteGroupTest extends TestBase {
    @Test
    public void testDeleteGroup() {
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.name("delete")).click();
        wd.findElement(By.linkText("group page")).click();
    }

}
