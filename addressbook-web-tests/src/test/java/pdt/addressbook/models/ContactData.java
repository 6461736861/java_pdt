package pdt.addressbook.models;

import org.openqa.selenium.By;

public class ContactData {
    public int id = Integer.MAX_VALUE;
    public String name;
    public String surname;

    public String homephone;
    public String work;
    public String mobile;

    public String address;
    public String companyName;
    public String title;

    public String email;
    public String email2;
    public String email3;

    public String allPhones;
    public String allEmails;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withHomephone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public ContactData withmobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withwork(String work) {
        this.work = work;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withaddress(String address) {
        this.address = address;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmails() {
        return allEmails;
    }


    public String getAddress() {
        return address;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getWork() {
        return work;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getHomePhone() {
        return homephone;
    }

    public String getTitle() {
        return title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", homephone='" + homephone + '\'' +
                ", work='" + work + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", companyName='" + companyName + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", allEmails='" + allEmails + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
        if (work != null ? !work.equals(that.work) : that.work != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
        return allEmails != null ? allEmails.equals(that.allEmails) : that.allEmails == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
        result = 31 * result + (work != null ? work.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
        result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
        return result;
    }

}
