public class Leetcode_1945 {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char x : s.toCharArray()) {
            int val = x - 'a' + 1;
            sum += val / 10 + val % 10;
        }
        k--;
        while (k > 0) {
            int currSum = 0;
            while (sum > 0) {
                currSum += sum % 10;
                sum /= 10;
            }
            sum = currSum;
        }
        return sum;
    }
}
