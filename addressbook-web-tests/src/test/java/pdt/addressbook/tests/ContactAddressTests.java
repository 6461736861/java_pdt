package pdt.addressbook.tests;

import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

//import static javafx.scene.CssStyleHelper.isTrue;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;
//import static org.testng.AssertJUnit.assertTrue;

public class ContactAddressTests extends TestBase {

    @Test
    public void testContactZIPCode() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFormEditForm = app.contact().infoFromEditorForm(contact);
        assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFormEditForm)));
    }

    private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

}
