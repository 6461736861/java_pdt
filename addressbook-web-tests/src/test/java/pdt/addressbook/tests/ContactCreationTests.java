package pdt.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new ContactData().withName("test name1").withaddress("someAddress1").withEmail("someemail@gmail.com")});
        list.add(new Object[]{new ContactData().withName("test name23").withaddress("someAddress44").withEmail("someema45il@gmail.com")});
        list.add(new Object[]{new ContactData().withName("test name234").withaddress("someAddress66").withEmail("someem765ail@gmail.com")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void createContactTest(ContactData contact) {
        Contacts before = app.contact().all();
        app.contact().initCreateContact();
        // File photo = new File("src/test/resources/contact.jpg");
        //  ContactData contact = new ContactData().withName(name).withSurname("with photo");//.withPhoto(photo);
        app.contact().fill(contact);
        app.contact().save();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        // assertThat(after.size(), equalTo(before.size() + 1));
        //  assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test
    public void checkingDerictory() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/contact.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
