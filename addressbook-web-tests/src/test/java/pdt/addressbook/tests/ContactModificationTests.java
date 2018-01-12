package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModitication() {
        List<ContactData> before = app.contact().contactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).getId()).withName("modified!!!!!").withSurname("surname");
        app.contact().selectContact();
        app.contact().modifyContact();
        app.contact().fill(contact);
        app.contact().saveChanges();

        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Address book updated\n" + "return to home page"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
//        List<ContactData> after = app.contact().contactList();
//
//        before.remove(index);
//        before.add(contact);
//        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!app.contact().isAnyContactExists()) {
            ContactData contact = new ContactData().withName("new customer").withSurname("new surname");//.withSurname("contact2");
            app.contact().create(contact);
        }
    }

}
