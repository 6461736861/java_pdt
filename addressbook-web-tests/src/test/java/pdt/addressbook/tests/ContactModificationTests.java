package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModitication() {
       // ContactData contact = new ContactData(null, null, null, null, null, null);
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "modified", "modified", "modified2","asd", "sdads");
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
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

    }

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!app.getContactHelper().isAnyContactExists()) {
            ContactData contact = new ContactData("modified", "modified", "modified2","asd", "sdads");
            app.getContactHelper().createContact(contact);
        }
    }

}
