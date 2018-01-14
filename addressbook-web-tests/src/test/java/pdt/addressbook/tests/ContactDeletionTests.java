package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.GroupData;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!app.contact().isAnyContactExists()) {
            ContactData contact = new ContactData().
                    withName(String.format("Name%s", UUID.randomUUID())).
                   withSurname(String.format("Surname%s", UUID.randomUUID()));
            app.contact().create(contact);
        }
    }

    @Test
    public void testDeleteContact() {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Record successful deleted"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }
}
