import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    class Pair {
        int weight;
        int value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

    static class RatioComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;
            return Double.compare(ratioB, ratioA);
        }
    }

    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, new RatioComparator());
        int currentWeight = 0;
        Double maxValue = 0.0;
        for (Pair p : items) {
            if (currentWeight + p.weight <= w) {
                currentWeight = currentWeight + p.weight;
                maxValue = maxValue + p.value;
            } else if (currentWeight < w) {
                int weightRequired = w - currentWeight;
                maxValue = maxValue + ((p.value * 1.0 / p.weight) * weightRequired);
                break;
            }
            if (currentWeight == w) {
                break;
            }
        }
        return maxValue;
    }
}
