package splitwise.groups;

import splitwise.balance.BalanceSheetController;
import splitwise.expense.Expense;
import splitwise.expense.ExpenseController;
import splitwise.split.SplitType;
import splitwise.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private String groupName;
    private final int groupId;
    private final List<User> users;
    private double totalExpense;
    private final List<Expense> expenseList;
    private final ExpenseController expenseController;

    public Group(BalanceSheetController balanceSheetController) {
        this.groupId = UUID.randomUUID().hashCode();
        this.users = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseController = new ExpenseController(balanceSheetController);
        this.totalExpense = 0;
    }

    public synchronized void addUser(User user) {
        for(User element : this.users) {
            if(element.getUserId() == user.getUserId()) {
                System.out.println("User already exists in the group");
                return;
            }
        }
        this.users.add(user);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupName(String name) {
        this.groupName = name;
    }

    public String getGroupName() {
        return this.groupName;
    }
    public List<Expense> getExpenseList() {
        return this.expenseList;
    }

    public Expense createExpense(User paidBy, List<Double> values, SplitType splitType, double amount, String desc) {
        Expense expense = this.expenseController.createExpense(desc, paidBy, this.users, values, splitType, amount);
        this.expenseList.add(expense);
        return expense;
    }




}
