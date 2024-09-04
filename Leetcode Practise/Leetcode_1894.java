public class Leetcode_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int x : chalk) {
            sum += x;
        }
        if (sum < k) {
            k %= sum;
        }
        if (k == 0) {
            return 0;
        }
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}