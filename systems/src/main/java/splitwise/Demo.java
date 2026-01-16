package splitwise;

import splitwise.split.SplitType;
import splitwise.users.User;
import splitwise.groups.Group;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        SplitwiseService splitwiseService = SplitwiseService.getInstance();
        //Create an user and a group
        User user1 = splitwiseService.createUser("U1");
        Group group1 = splitwiseService.createGroup("Flat", user1);

        //Add more users
        User user2 = splitwiseService.createUser("U2");
        User user3 = splitwiseService.createUser("U3");

        //Add more members to the group
        splitwiseService.addUsersToGroup(group1.getGroupId(), user2);
        splitwiseService.addUsersToGroup(group1.getGroupId(), user3);

        List<Double> values1 = new ArrayList<>();
        List<Double> values2 = List.of(25.0, 25.0, 50.0);
        List<Double> values3 = List.of(50.0, 75.0, 25.0);

        //add expenses to the group
        splitwiseService.createGroupExpense(user1, group1.getGroupId(), 120, SplitType.EQUAL, values1, "Dinner");
        splitwiseService.createGroupExpense(user2, group1.getGroupId(), 100, SplitType.PERCENTAGE, values2, "Lunch");
        splitwiseService.createGroupExpense(user1, group1.getGroupId(), 150, SplitType.UNEQUAL, values3, "Shopping");

        splitwiseService.displayBalances();
        splitwiseService.displayTotalBalances();
    }
}
