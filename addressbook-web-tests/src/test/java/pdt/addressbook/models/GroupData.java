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

//    public void GroupData() {
//        group_name = String.format("Group name%s", UUID.randomUUID());
//        group_footer = String.format("Footer%s", UUID.randomUUID());
//        group_header = String.format("Header%s", UUID.randomUUID());
//    }
}