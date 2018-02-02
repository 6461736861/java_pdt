package pdt.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/rb/java_pdt/addressbook-web-tests/" +
                "src/test/resources/contacts.json"));
        String json = " ";
        Gson gson = new Gson();
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType());
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContacts")
    public void createContactTest(ContactData contact) {
        Contacts before = app.contact().all();
        app.contact().initCreateContact();
        app.contact().fill(contact);
        app.contact().save();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
       }

    @Test(alwaysRun = false)
    public void checkingDerictory() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/contact.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
