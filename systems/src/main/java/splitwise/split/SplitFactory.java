package splitwise.split;

public class SplitFactory {
    public static SplitStrategy getSplitType(SplitType type) {
        if(type.equals(SplitType.EQUAL)) {
            return new EqualSplit();
        } else if(type.equals(SplitType.UNEQUAL)) {
            return new UnequalSplit();
        } else if(type.equals(SplitType.PERCENTAGE)) {
            return new PercentageSplit();
        } else {
            throw new IllegalArgumentException("Invalid Split Type chosen");
        }
    }
}
