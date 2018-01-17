package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
