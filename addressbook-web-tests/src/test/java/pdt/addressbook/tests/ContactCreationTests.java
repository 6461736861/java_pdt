package pdt.addressbook.tests;

import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test
    public void createContactTest() {
        Contacts before = app.contact().all();
        app.contact().initCreateContact();
        File photo = new File("src/test/resources/contact.jpg");
        ContactData contact = new ContactData().withName("my new name").withSurname("with photo").withPhoto(photo);
        app.contact().fill(contact);
        app.contact().save();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        //assertThat(after.size(), equalTo(before.size() + 1));
//        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test
    public void checkingDerictory() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File ("src/test/resources/contact.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
