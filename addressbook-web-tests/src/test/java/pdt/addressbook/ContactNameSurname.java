package pdt.addressbook;

public class ContactNameSurname {
    private final String contactName;
    private final String contactSurname;
    private final String contactNickname;
    private final String salutation;

    public ContactNameSurname(String contactName, String contactSurname, String contactNickname, String salutation) {
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactNickname = contactNickname;
        this.salutation = salutation;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public String getContactNickname() {
        return contactNickname;
    }

    public String getSalutation() {
        return salutation;
    }
}
