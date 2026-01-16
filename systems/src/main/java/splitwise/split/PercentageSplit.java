package splitwise.split;

import splitwise.users.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplit implements SplitStrategy {
    @Override
    public List<Split> calculateSplit(List<User> users, List<Double> values, double total) {
        List<Split> splits = new ArrayList<>();
        double totalPercentage = 0;

        for(Double value : values) {
            totalPercentage += value;
        }

        if(totalPercentage != 100) {
            throw new IllegalArgumentException("Total percentages does not add up to 100");
        }

        for(int i=0;i<users.size();i++) {
            double amount = (values.get(i)*total)/100;
            splits.add(new Split(users.get(i), amount));
        }

        return splits;
    }
}
