package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModitication() {
        // ContactData contact = new ContactData(null, null, null, null, null, null);
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "test1", "test2", "test3", "test4");
        app.getContactHelper().selectContact();
        app.getContactHelper().modifyContact();
        app.getContactHelper().fillContact(contact); //.fillContactBirthDate();
        app.getContactHelper().saveContactChanges();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Address book updated\n" + "return to home page"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!app.getContactHelper().isAnyContactExists()) {
            ContactData contact = new ContactData(0, "test1", "test2", "test3", "test4");
            app.getContactHelper().createContact(contact);
        }
    }

}
