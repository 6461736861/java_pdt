package pdt.addressbook.models;

public class ContactData {
    public int id;
    public String name;
    public String surname;
    public String nickname;
    public String title;
    public String companyName;
    public String email;

    public ContactData(int id, String name, String surname, String nickname, String title, String companyName, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.title = title;
        this.companyName = companyName;
        this.email = email;
    }

    public ContactData(String name, String surname, String nickname, String title, String companyName, String email) {
        this.id = 0;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.title = title;
        this.companyName = companyName;
        this.email = email;
    }

    public ContactData(String name, String surname, String email, String title) {
        this.id = 0;
        this.name = name;
        this.surname = surname;
        this.email = nickname;
        this.title = title;
    }

    public ContactData(int id, String name, String surname, String email, String title) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = nickname;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
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
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
