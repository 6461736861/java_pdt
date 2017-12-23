package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactAddress;

public class DeleteContactTests extends TestBase {

    @Test
    public void testDeleteContact() {
        contactHelper.createContact();

        contactHelper.deleteContact();
        contactHelper.submitDeletionContact();

        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        new WebDriverWait(wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Record successful deleted"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));


    }
}
