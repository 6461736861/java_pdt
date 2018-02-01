package pdt.addressbook.generators;

import com.sun.javafx.binding.StringFormatter;
import pdt.addressbook.models.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rb on 2/1/18.
 */
public class GroupDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<GroupData> groups = generateGroups(count);
        save(groups, file);


    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (GroupData group : groups) {
            writer.write(String.format("%s; %s; %s\n", group.getGroup_name(), group.getGroup_footer(), group.getGroup_header()));
        }
        writer.close();
    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData().withName(String.format("test%s", i))
                    .withFooters(String.format("footer%s", i))
                    .withHeader(String.format("header%s", i)));
        }
        return groups;
    }
}
