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
        this.id = Integer.MAX_VALUE;
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

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
