package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    public void createContactTest() {
        List<ContactData> before = app.contact().contactList();
        app.contact().initCreateContact();
        ContactData contact = new ContactData(0, "test1", "test2", "test3", "test4");
        app.contact().fill(contact);
        app.contact().save();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Information entered into address book.\n" + "add next or return to home page."));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
