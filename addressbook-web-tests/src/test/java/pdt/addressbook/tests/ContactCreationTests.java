package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactCreationTests extends TestBase {

    @Test
    public void createContactTest() {
        Set<ContactData> before = app.contact().all();
        app.contact().initCreateContact();
        ContactData contact = new ContactData().withName("contact1").withSurname("hello");
        app.contact().fill(contact);
        app.contact().save();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Information entered into address book.\n" + "add next or return to home page."));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
