package pdt.addressbook.tests;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;


public class ContactCreationTests extends TestBase{

    @Test
    public void createContactTest() {
        app.getContactHelper().initCreatContact();
        app.getContactHelper().fillContactNameSurnameSalutation(new ContactNameSurname("Dasha", "Test", "nickname", "MS"));
        app.getContactHelper().fillContactPersonalData(new ContactAddress("someCompany", "Grafenberger Allee 222", "1111111", "dasha@gmail.com"));
        app.getContactHelper().saveContact();
    }

}
