package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModitication() {
        ContactData contact = new ContactData();
        contactHelper.selectContact();
        contactHelper.modifyContact();
        contactHelper.createContact(contact);//fillContact(new ContactNameSurname("NEW NAME", "TEST", "NEW NICKNAME", "MS"));
       // contactHelper.fillContactPersonalData(new ContactAddress("newCompany", "BeachStreet", "3333", "sasdfkajhgdfj@fgfdg.sdf"));
        contactHelper.fillContactBirthDate();
        contactHelper.saveContactChanges();

        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Address book updated\n" + "return to home page"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));

    }
}
