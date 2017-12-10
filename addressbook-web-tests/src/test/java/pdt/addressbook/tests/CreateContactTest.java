package pdt.addressbook.tests;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;


public class CreateContactTest extends TestBase{

    @Test
    public void createContactTest() {
        app.initCreatContact();
        app.fillContactNameSurnameSalutation(new ContactNameSurname("Dasha", "Test", "nickname", "MS"));
        app.fillContactPersonalData(new ContactAddress("someCompany", "Grafenberger Allee 222", "1111111", "dasha@gmail.com"));
        app.fillCOntactBirthDate();
        tearDown();
    }

}
