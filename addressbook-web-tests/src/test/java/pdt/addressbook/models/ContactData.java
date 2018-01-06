package pdt.addressbook.models;

public class ContactData {
    public String id;
    public String name;
    public String surname;
    public String nickname;
    public String title;
    public String companyName;
    public String email;

    public ContactData(String id, String name, String surname, String nickname, String title, String companyName, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.title = title;
        this.companyName = companyName;
        this.email = email;
    }

    public ContactData(String name, String surname, String nickname, String title, String companyName, String email) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.title = title;
        this.companyName = companyName;
        this.email = email;
    }

    public ContactData(String name, String surname, String email, String title) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.email = nickname;
        this.title = title;
    }

    public ContactData(String id, String name, String surname, String email, String title) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = nickname;
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public ContactData withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
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
}
