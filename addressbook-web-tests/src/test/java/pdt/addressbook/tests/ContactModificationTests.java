package pdt.addressbook.tests;

import org.testng.annotations.Test;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModitication() {
        app.getContactHelper().selectContact();
        app.getContactHelper().modifyContact();
        app.getContactHelper().fillContactNameSurnameSalutation(new ContactNameSurname("NEW NAME", "TEST", "NEW NICKNAME", "MS"));
        app.getContactHelper().fillContactPersonalData(new ContactAddress("newCompany", "BeachStreet", "3333", "sasdfkajhgdfj@fgfdg.sdf"));
        app.getContactHelper().fillCOntactBirthDate();
        app.getContactHelper().saveContactChanges();
    }
}
