package pdt.addressbook.tests;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;


public class CreateContactTest extends TestBase{

    @Test
    public void createContactTest() {
        app.getContactCreationHelper().initCreatContact();
        app.getContactCreationHelper().fillContactNameSurnameSalutation(new ContactNameSurname("Dasha", "Test", "nickname", "MS"));
        app.getContactCreationHelper().fillContactPersonalData(new ContactAddress("someCompany", "Grafenberger Allee 222", "1111111", "dasha@gmail.com"));
        app.getContactCreationHelper().fillCOntactBirthDate();
        tearDown();
    }

}
