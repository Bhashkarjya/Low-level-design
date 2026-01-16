package splitwise.expense;

import java.util.List;

import splitwise.balance.BalanceSheetController;
import splitwise.split.Split;
import splitwise.split.SplitFactory;
import splitwise.split.SplitStrategy;
import splitwise.users.User;
import splitwise.split.SplitType;
public class ExpenseController {
    private final BalanceSheetController balanceSheetController;
    public ExpenseController (BalanceSheetController balanceSheetController) {
        this.balanceSheetController = balanceSheetController;
    }
    public Expense createExpense(String description, User paidBy, List<User> userList, List<Double> values, SplitType type, double total) {
        SplitStrategy strategy = SplitFactory.getSplitType(type);
        List<Split> splits = strategy.calculateSplit(userList, values, total);
        Expense expense = new Expense(description, total, paidBy, type, splits);
        this.balanceSheetController.updateUserBalanceSheet(expense);
        return expense;
    }

    public void deleteExpense(int expenseId) {

    }

    public void updateExpense(int expenseId) {

    }
}
