package splitwise;

import splitwise.balance.BalanceSheetController;
import splitwise.groups.GroupController;
import splitwise.split.SplitType;
import splitwise.users.UserController;
import splitwise.users.User;
import splitwise.groups.Group;
import splitwise.expense.Expense;
import java.util.List;

public class SplitwiseService {
    private final UserController userController;
    private final BalanceSheetController balanceSheetController;
    private final GroupController groupController;
    private static volatile SplitwiseService instance;

    private SplitwiseService() {
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.balanceSheetController = new BalanceSheetController();
    }

    public static SplitwiseService getInstance() {
        if(instance == null) {
            synchronized (SplitwiseService.class) {
                if(instance == null) {
                    instance = new SplitwiseService();
                }
            }
        }

        return instance;
    }

    public User createUser(String name) {
        User createdUser = this.userController.createUser(name);
        System.out.println("Created user : " + createdUser.getUserName() + " " + createdUser.getUserId());
        return createdUser;
    }

    public Group createGroup(String groupName, User groupOwner) {
        Group group = this.groupController.createGroup(groupName, groupOwner, this.balanceSheetController);
        System.out.println("Created group : " + group.getGroupName() + " " + group.getGroupId());
        return group;
    }

    public void addUsersToGroup(int groupId, User user) {
        this.groupController.getGroup(groupId).addUser(user);
    }

    public Expense createGroupExpense(User expenseOwner, int groupId, double total, SplitType type, List<Double> values, String description) {
        Group group = this.groupController.getGroup(groupId);
        Expense expense = group.createExpense(expenseOwner, values, type, total, description);
        System.out.println("Added an expense : " + expense.getSplitDetails());
        return expense;
    }

    public void displayBalances() {
        for(User user : this.userController.getAllUsers()) {
            this.balanceSheetController.displayBalanceSheet(user);
        }
    }

    public void displayTotalBalances() {
        System.out.println("Displaying total balances");
        for(User user : this.userController.getAllUsers()) {
            double amount = user.getBalanceSheet().getTotalBalance();
            System.out.println(user.getUserName() + "--->" + amount);
        }
    }

}
