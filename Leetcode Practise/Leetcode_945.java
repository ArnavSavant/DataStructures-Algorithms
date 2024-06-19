public class Leetcode_945 {
    public int minIncrementForUnique(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int val : nums) {
            max = Math.max(max, val);
        }
        int freq[] = new int[max + n];
        for (int val : nums) {
            freq[val]++;
        }
        int moves = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) {
                freq[i + 1] += freq[i] - 1;
                freq[i] = 1;
                moves += freq[i] - 1;
                ;
            }
        }
        return moves;
    }
}
