package splitwise.balance;

import splitwise.users.User;

import java.util.Map;
import java.util.List;
import splitwise.expense.Expense;
import splitwise.split.Split;


public class BalanceSheetController {

    public void displayBalanceSheet(User user) {
        BalanceSheet balanceSheet = user.getBalanceSheet();
        System.out.println("Displaying balance sheet for User : " + user.getUserName());
        for(Map.Entry<String, Double> entry : balanceSheet.getBalanceSheet().entrySet()) {
            String username = entry.getKey();
            double amount = entry.getValue();
            System.out.println(username + "--->" + amount);
        }
    }

    //Update the balance sheet of the users after adding a new expense
    public void updateUserBalanceSheet(Expense expense) {
        List<Split> splits = expense.getSplitDetails();
        User paidBy = expense.getPaidBy();
        Map<String, Double> expenseOwnerBalanceSheet = paidBy.getBalanceSheet().getBalanceSheet();

        for(Split split : splits) {
            if(split.getUser().getUserId() == paidBy.getUserId()) {
                continue;
            }
            User user = split.getUser();

            synchronized (paidBy.getBalanceSheet()) {
                expenseOwnerBalanceSheet.put(user.getUserName(), expenseOwnerBalanceSheet.getOrDefault(user.getUserName(),0.0) + split.getAmount());
                paidBy.getBalanceSheet().incrementBalance(split.getAmount());
            }

            Map<String, Double> userBalanceSheet = user.getBalanceSheet().getBalanceSheet();

            synchronized (user.getBalanceSheet()) {
                userBalanceSheet.put(paidBy.getUserName(), userBalanceSheet.getOrDefault(paidBy.getUserName(), 0.0) - split.getAmount());
                user.getBalanceSheet().decrementBalance(split.getAmount());
            }
        }
    }
}
