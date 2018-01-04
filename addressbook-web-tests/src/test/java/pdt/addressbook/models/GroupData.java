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
    public String group_name;
    public String group_header;
    public String group_footer;

    @Override
    public String toString() {
        return "GroupData{" +
                "group_name='" + group_name + '\'' +
                '}';
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
}