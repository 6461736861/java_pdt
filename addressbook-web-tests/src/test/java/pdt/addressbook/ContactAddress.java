package pdt.addressbook;

public class ContactAddress {
    private final String companyName;
    private final String contactStreet;
    private final String contactPhone;
    private final String contactEmail;

    public ContactAddress(String companyName, String contactStreet, String contactPhone, String contactEmail) {
        this.companyName = companyName;
        this.contactStreet = contactStreet;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactStreet() {
        return contactStreet;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
