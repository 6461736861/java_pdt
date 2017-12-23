package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModitication() {
        contactHelper.selectContact();
        contactHelper.modifyContact();
        contactHelper.fillContactNameSurnameSalutation(new ContactNameSurname("NEW NAME", "TEST", "NEW NICKNAME", "MS"));
        contactHelper.fillContactPersonalData(new ContactAddress("newCompany", "BeachStreet", "3333", "sasdfkajhgdfj@fgfdg.sdf"));
        contactHelper.fillCOntactBirthDate();
        contactHelper.saveContactChanges();

        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Address book updated\n" + "return to home page"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));

    }
}
