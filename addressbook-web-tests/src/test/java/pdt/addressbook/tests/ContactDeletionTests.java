package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.List;
import java.util.UUID;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!app.getContactHelper().isAnyContactExists()) {
            ContactData contact = new ContactData(String.format("Name%s", UUID.randomUUID()),
                    String.format("Surname%s", UUID.randomUUID()),
                    String.format("email%s@gmail.com", UUID.randomUUID()),
                    String.format("Title%s", UUID.randomUUID()));
            app.getContactHelper().createContact(contact);
        }
    }

    @Test
    public void testDeleteContact() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().deleteContact();
        app.getContactHelper().submitDeletionContact();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Record successful deleted"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        //check that lists before and after are equals
        Assert.assertEquals(before, after);
    }
}
