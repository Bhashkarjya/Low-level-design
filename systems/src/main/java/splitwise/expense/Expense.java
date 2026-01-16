package splitwise.expense;

import splitwise.split.SplitType;
import splitwise.users.User;
import splitwise.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final int expenseId;
    private String expenseDescription;
    private double amount;
    private User paidBy;
    private List<Split> splitDetails;
    private SplitType splitType;

    public Expense(String desc, double amount, User paidBy, SplitType type, List<Split> splitDetails) {
        this.expenseId = UUID.randomUUID().hashCode();
        this.expenseDescription = desc;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitDetails = splitDetails;
        this.splitType = type;
    }

    public List<Split> getSplitDetails() {
        return this.splitDetails;
    }

    public User getPaidBy() {
        return this.paidBy;
    }

    public double getAmount() {
        return this.amount;
    }


}
