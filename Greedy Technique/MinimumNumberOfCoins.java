import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfCoins {
    public static List<Integer> MinimumCoins(int n) {
        int coins[] = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
        List<Integer> answer = new ArrayList<>();
        int ind = 0;
        while (n != 0) {
            if (n > coins[ind]) {
                answer.add(coins[ind]);
                n = n - coins[ind];
            } else {
                ind++;
            }
        }
        return answer;
    }
}
