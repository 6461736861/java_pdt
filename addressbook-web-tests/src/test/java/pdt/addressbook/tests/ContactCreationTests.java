package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.UUID;


public class ContactCreationTests extends TestBase {

    @Test
    public void createContactTest() {
        ContactData contact = new ContactData();
        contact.name = String.format("Name%s", UUID.randomUUID());
        contact.surname = String.format("Surname%s", UUID.randomUUID());
        contact.email = String.format("email%s@gmail.com", UUID.randomUUID());
        contact.title = String.format("Title%s", UUID.randomUUID());
        contactHelper.createContact(contact);
        contactHelper.initCreateContact();
        contactHelper.fillContact(new ContactData());
        contactHelper.saveContact();

        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Information entered into address book.\n" + "add next or return to home page."));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
    }

}
