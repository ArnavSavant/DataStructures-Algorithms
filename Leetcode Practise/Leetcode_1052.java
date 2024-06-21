public class Leetcode_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                sum = sum + customers[i];
            }
        }
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (j < grumpy.length) {
            if (grumpy[j] == 1) {
                sum = sum + customers[j];
            }
            if (j - i + 1 < minutes) {
                j++;
            } else if (j - i + 1 == minutes) {
                max = Math.max(max, sum);
                if (grumpy[i] == 1) {
                    sum = sum - customers[i];
                }
                i++;
                j++;
            }
        }
        return max;
    }
}
