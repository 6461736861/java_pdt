package pdt.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.Contacts;
import pdt.addressbook.models.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader("/Users/rb/java_pdt/addressbook-web-tests/src/test/resources/contacts.json"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withName(split[0]).withaddress(split[1]).withEmail(split[2])});
            line = reader.readLine();
        }
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
