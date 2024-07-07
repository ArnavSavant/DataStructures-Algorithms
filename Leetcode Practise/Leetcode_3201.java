public class Leetcode_3201 {
    public int maximumLength(int[] nums) {
        int allOdd = 0;
        int allEven = 0;
        for (int x : nums) {
            if (x % 2 == 1) {
                allOdd++;
            } else {
                allEven++;
            }
        }
        int oddFirst = 0;
        int evenFirst = 0;
        boolean isOdd = true;
        for (int x : nums) {
            if ((isOdd && (x % 2 == 1)) || (!isOdd && (x % 2 == 0))) {
                oddFirst++;
                isOdd = !isOdd;
            }
        }
        isOdd = false;
        for (int x : nums) {
            if ((isOdd && (x % 2 == 1)) || (!isOdd && (x % 2 == 0))) {
                evenFirst++;
                isOdd = !isOdd;
            }
        }
        return Math.max(Math.max(allEven, allOdd), Math.max(oddFirst, evenFirst));
    }
}
