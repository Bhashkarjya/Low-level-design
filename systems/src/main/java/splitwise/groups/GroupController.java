package splitwise.groups;

import java.util.ArrayList;
import java.util.List;

import splitwise.balance.BalanceSheetController;
import splitwise.users.User;
public class GroupController {
    private final List<Group> groupList;

    public GroupController() {
        this.groupList = new ArrayList<>();
    }

    public Group createGroup(String name, User createdBy, BalanceSheetController balanceSheetController) {
        Group group = new Group(balanceSheetController);
        group.setGroupName(name);
        group.addUser(createdBy);
        this.groupList.add(group);
        return group;
    }

    public Group getGroup(int groupId) {
        for(Group group : this.groupList) {
            if(group.getGroupId() == groupId) {
                return group;
            }
        }

        return null;
    }
}
