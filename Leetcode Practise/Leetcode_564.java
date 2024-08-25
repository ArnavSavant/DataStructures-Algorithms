public class Leetcode_564 {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        if (num <= 10) {
            return String.valueOf(num - 1);
        }
        if (num == 11) {
            return "9";
        }
        int len = n.length();
        long leftHalf = Long.parseLong(n.substring(0, (len + 1) / 2));

        long palindrome[] = new long[5];
        palindrome[0] = findPalindrome(leftHalf, len % 2 == 0);
        palindrome[1] = findPalindrome(leftHalf - 1, len % 2 == 0);
        palindrome[2] = findPalindrome(leftHalf + 1, len % 2 == 0);
        palindrome[3] = (long) Math.pow(10, len) + 1;
        palindrome[4] = (long) Math.pow(10, len - 1) - 1;

        long nearestPalindrome = 0;
        long minDifference = Long.MAX_VALUE;
        for (long candidate : palindrome) {
            if (candidate == num) {
                continue;
            }
            long difference = Math.abs(candidate - num);
            if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
                minDifference = difference;
                nearestPalindrome = candidate;
            }
        }
        return String.valueOf(nearestPalindrome);
    }

    private long findPalindrome(long leftHalf, boolean isEven) {
        long palindrome = leftHalf;
        if (!isEven) {
            leftHalf = leftHalf / 10;
        }
        while (leftHalf > 0) {
            palindrome = palindrome * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        return palindrome;
    }
}
