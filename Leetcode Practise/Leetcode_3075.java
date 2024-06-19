import java.util.Arrays;

public class Leetcode_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        Arrays.sort(happiness);
        int ind = happiness.length - 1;
        int x = 0;
        while (k-- != 0) {
            if (happiness[ind] - x <= 0) {
                break;
            }
            sum = sum + (happiness[ind] - x);
            ind--;
            x++;
        }
        return sum;
    }
}
