package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pdt.addressbook.models.GroupData;
import pdt.addressbook.models.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.name;

/**
 * Created by rb on 12/10/17.
 */
public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(name("submit"));
    }

    public void fillGroupForm(GroupData group) {
        typeFieldValue(name("group_name"), group.group_name);
        typeFieldValue(name("group_header"), group.group_header);
        typeFieldValue(name("group_footer"), group.group_footer);
    }

    public void initGroup() {
        click(name("new"));
    }

    public void deleteSelected() {
        click(name("delete"));
    }

    public void selectGroupByID(int id) {
        wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
    }

    public void initGroupModification() {
        click(name("edit"));
    }

    public void submitGroupModification() {
        click(name("update"));
    }


    public boolean isAnyGroupExists() {
        return !(wd.findElements(By.cssSelector(".group")).size() == 0);

    }

    public void create(GroupData group) {
        initGroup();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
    }

    public void modifyGroup( GroupData group) {
        selectGroupByID(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        goToGroupPage();
    }

    private Groups groupCache = null;
    public Groups all(){
        if(groupCache !=null) {
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(GroupData group) {
        selectGroupByID(group.getId());
        deleteSelected();
        groupCache = null;
        goToGroupPage();

    }
}