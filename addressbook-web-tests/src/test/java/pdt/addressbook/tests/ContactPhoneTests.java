package pdt.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFormEditForm = app.contact().infoFromEditorForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobile(), contact.getWork())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("-()", "");
    }
}
