package pdt.addressbook;
import org.testng.annotations.Test;


public class CreateContactTest extends TestBase{

    @Test

    public void createContactTest() {
        initCreatContact();
        fillContactNameSurnameSalutation(new ContactNameSurname("Dasha", "Test", "nickname", "MS"));
        fillContactPersonalData(new ContactAddress("someCompany", "Grafenberger Allee 222", "1111111", "dasha@gmail.com"));
        fillCOntactBirthDate();
        tearDown();
    }

}
