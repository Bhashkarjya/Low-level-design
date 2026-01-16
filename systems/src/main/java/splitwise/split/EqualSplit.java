package splitwise.split;

import splitwise.users.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitStrategy {
    @Override
    public List<Split> calculateSplit(List<User> users, List<Double> values, double total) {
        List<Split> splits = new ArrayList<>();
        double amount = total/users.size();

        for(int i=0;i<users.size();i++) {
            splits.add(new Split(users.get(i), amount));
        }

        return splits;
    }
}
