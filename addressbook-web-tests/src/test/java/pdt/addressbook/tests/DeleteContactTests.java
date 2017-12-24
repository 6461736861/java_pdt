package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.UUID;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!contactHelper.isAnyContactExists()) {
            ContactData contact = new ContactData();
            contact.name = String.format("Name%s", UUID.randomUUID());
            contact.surname = String.format("Surname%s", UUID.randomUUID());
            contact.email = String.format("email%s@gmail.com", UUID.randomUUID());
            contact.title = String.format("Title%s", UUID.randomUUID());
            contactHelper.createContact(contact);
        }
    }

    @Test
    public void testDeleteContact() {

        contactHelper.deleteContact();
        contactHelper.submitDeletionContact();

        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Record successful deleted"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));

    }


}
