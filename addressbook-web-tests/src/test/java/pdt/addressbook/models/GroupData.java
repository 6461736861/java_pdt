//package pdt.addressbook.models;
//
//public class GroupData {
//    private final String groupName;
//    private final String groupHeader;
//    private final String groupFooter;
//
//    public GroupData(String groupName, String groupHeader, String groupFooter) {
//        this.groupName = groupName;
//        this.groupHeader = groupHeader;
//        this.groupFooter = groupFooter;
//    }
//
//    public String getGroupName() {
//        return groupName;
//    }
//
//    public String getGroupHeader() {
//        return groupHeader;
//    }
//
//    public String getGroupFooter() {
//        return groupFooter;
//    }
//}

package pdt.addressbook.models;

import java.util.UUID;

public class GroupData {
    public int id;
    public String group_name;
    public String group_header;
    public String group_footer;

    public GroupData(String group_name, String group_header, String group_footer) {
        this.id = Integer.MAX_VALUE;
        this.group_name = group_name;
        this.group_header = group_header;
        this.group_footer = group_footer;
    }

    public GroupData(int id, String group_name, String group_header, String group_footer) {
        this.id = id;
        this.group_name = group_name;
        this.group_header = group_header;
        this.group_footer = group_footer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        return group_name != null ? group_name.equals(groupData.group_name) : groupData.group_name == null;
    }

    @Override
    public int hashCode() {
        return group_name != null ? group_name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", group_name='" + group_name + '\'' +
                '}';
    }

}