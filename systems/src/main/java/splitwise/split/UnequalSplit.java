package splitwise.split;

import splitwise.users.User;

import java.util.ArrayList;
import java.util.List;

public class UnequalSplit implements SplitStrategy {
    @Override
    public List<Split> calculateSplit(List<User> users, List<Double> values, double total) {
        double amount = 0;
        for(Double value : values) {
            amount += value;
        }
        if(amount != total) {
            throw new IllegalArgumentException("Splits does not sum up to total");
        }
        List<Split> splits = new ArrayList<>();
        for(int i=0;i<users.size();i++) {
            splits.add(new Split(users.get(i), values.get(i)));
        }

        return splits;
    }
}
