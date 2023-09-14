import java.math.BigInteger;

public class Leetcode_8 {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            end = 1;
        }
        while (end < s.length()) {
            if (s.charAt(end) >= '0' && s.charAt(end) <= '9') {
                end++;
            } else {
                break;
            }
        }
        if (start == end || (end - start == 1 && (s.charAt(start) == '-' || s.charAt(start) == '+'))) {
            return 0;
        }
        BigInteger x = new BigInteger(s.substring(start, end));
        if (x.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            x = BigInteger.valueOf(Integer.MIN_VALUE);
        } else if (x.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            x = BigInteger.valueOf(Integer.MAX_VALUE);
        }

        return x.intValue();
    }
    /*
    RECURRSIVE IMPLEMENTATION
    public int solve(String s, boolean signFound, boolean isNegative) {
        if (s.isEmpty() || (!Character.isDigit(s.charAt(0)) && (s.charAt(0) != '+' && s.charAt(0) != '-'))) {
            return 0;
        }
        if (signFound && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            return 0;
        }
        if (!signFound && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            isNegative = (s.charAt(0) == '-') ? true : false;
            signFound = true;
            return solve(s.substring(1), signFound, isNegative);
        }

        int digit = s.charAt(0) - '0';
        int nextValue = solve(s.substring(1), signFound, isNegative);
        System.out.println("values: " + s.charAt(0) + " " + digit + " " + nextValue);
        long result = isNegative ? -digit : digit;
        result = result * (long) Math.pow(10, (int) Math.log10(nextValue + 1)) + nextValue;
        System.out.println("result: " + result);
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) result;
        }
    }
    */
}

/*
 * Alright, esteemed students, let's dissect this code to understand its
 * underlying logic, purpose, and intuition. The function `myAtoi` aims to
 * implement a rudimentary version of the `atoi` function (ASCII to Integer).
 * The `atoi` function takes a string, which represents an integer in ASCII, and
 * converts it into an actual integer.
 * 
 * 1. **Beginning With a Clean Slate**:
 * ```java
 * s = s.trim();
 * if (s.length() == 0) {
 * return 0;
 * }
 * ```
 * The code starts by removing leading and trailing white spaces from the string
 * `s`. If after trimming, the string is empty, it returns 0. This handles
 * strings that are purely white spaces.
 * 
 * 2. **Setting the Bounds**:
 * ```java
 * int start = 0;
 * int end = 0;
 * if (s.charAt(0) == '-' || s.charAt(0) == '+') {
 * end = 1;
 * }
 * ```
 * The above snippet establishes the starting point (`start`) for the substring
 * that'll represent our number. If the string begins with a sign (either '+' or
 * '-'), we adjust the `end` pointer accordingly.
 * 
 * 3. **Extracting the Number**:
 * ```java
 * while (end < s.length()) {
 * if (s.charAt(end) >= '0' && s.charAt(end) <= '9') {
 * end++;
 * } else {
 * break;
 * }
 * }
 * ```
 * This loop progresses through the string from the current `end` index,
 * expanding as long as it encounters numeric characters. If it sees a
 * non-numeric character, the loop halts.
 * 
 * 4. **Handling Edge Cases**:
 * ```java
 * if (start == end || (end-start == 1 && (s.charAt(start) == '-' ||
 * s.charAt(start) == '+'))) {
 * return 0;
 * }
 * ```
 * The above conditions ensure that we're not processing invalid strings. It
 * checks if we have no numbers or if we only have a sign with no accompanying
 * number. In these cases, it returns 0.
 * 
 * 5. **Converting String to BigInteger and Bound Checking**:
 * ```java
 * BigInteger x = new BigInteger(s.substring(start, end));
 * if (x.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
 * x = BigInteger.valueOf(Integer.MIN_VALUE);
 * } else if (x.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
 * x = BigInteger.valueOf(Integer.MAX_VALUE);
 * }
 * ```
 * The `substring(start, end)` captures our desired string of numbers (with a
 * potential preceding sign). We then initialize a `BigInteger` with it. Why
 * `BigInteger`? This ensures we don't run into overflow issues if the string
 * represents a number outside the bounds of Java's `int`.
 * 
 * After converting to a `BigInteger`, we ensure that our value lies within the
 * confines of Java's `Integer.MIN_VALUE` and `Integer.MAX_VALUE`. If it's
 * smaller than `Integer.MIN_VALUE`, we set it to `Integer.MIN_VALUE`, and if
 * it's larger than `Integer.MAX_VALUE`, we set it to `Integer.MAX_VALUE`.
 * 
 * 6. **Final Conversion**:
 * ```java
 * return x.intValue();
 * ```
 * The last step is simply converting our `BigInteger` back to an integer.
 ** 
 * Intuition**: This function attempts to mimic the behavior of parsing integers
 * from strings, just like one would read numbers in textual formats. It starts
 * from the left, looks for valid signs, reads digits, and stops at the first
 * invalid character. The use of `BigInteger` provides a way to navigate around
 * potential pitfalls of overflow.
 * 
 * In essence, this function is an exercise in careful string manipulation,
 * range checking, and conversion between data types.
 */
