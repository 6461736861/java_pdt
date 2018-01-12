package pdt.addressbook.models;

public class GroupData {
    private int id = Integer.MAX_VALUE;
    public String group_name;
    public String group_header;
    public String group_footer;

    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withName(String group_name) {
        this.group_name = group_name;
        return this;
    }

    public GroupData withHeader(String group_header) {
        this.group_header = group_header;
        return this;
    }

    public GroupData withFooters(String group_footer) {
        this.group_footer = group_footer;
        return this;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getGroup_header() {
        return group_header;
    }

    public String getGroup_footer() {
        return group_footer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return group_name != null ? group_name.equals(groupData.group_name) : groupData.group_name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (group_name != null ? group_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", group_name='" + group_name + '\'' +
                '}';
    }
}