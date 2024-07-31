public class Leetcode_3232 {
    public boolean canAliceWin(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int x : nums) {
            if (x < 10) {
                sum1 += x;
            } else {
                sum2 += x;
            }
        }
        return sum1 != sum2;
    }
}
