package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.GroupData;

import java.util.List;
import java.util.UUID;


public class ContactCreationTests extends TestBase {

    @Test
    public void createContactTest() {
       // ContactData contact = new ContactData(null, null, null, null);
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initCreateContact();
        app.getContactHelper().fillContact(new ContactData(String.format("Name%s", UUID.randomUUID()),
                String.format("Surname%s", UUID.randomUUID()),
                String.format("email%s@gmail.com", UUID.randomUUID()),
                String.format("Title%s", UUID.randomUUID())));
        app.getContactHelper().saveContact();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Information entered into address book.\n" + "add next or return to home page."));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
