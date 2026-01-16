package splitwise.split;

import splitwise.users.User;

import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSplit(List<User> users, List<Double> values, double total);
}
