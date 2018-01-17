package pdt.addressbook.tests;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test
    public void createContactTest() {
        Contacts before = app.contact().all();
        app.contact().initCreateContact();
        ContactData contact = new ContactData().withName("contact1").withSurname("hello");
        app.contact().fill(contact);
        app.contact().save();

        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
