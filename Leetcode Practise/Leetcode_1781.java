public class Leetcode_1781 {
    public int beautySum(String s) {
        int beautySum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int beauty = findBeauty(s.substring(i, j + 1));
                beautySum = beautySum + beauty;
            }
        }
        return beautySum;
    }

    public int findBeauty(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int temp[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                max = Math.max(max, temp[i]);
                min = Math.min(min, temp[i]);
            }
        }
        return max - min;
    }
}
/*
Alright, class! Let's delve into this piece of code. Today, we have a function called `beautySum` which seems to calculate a certain "beauty" value for a string and sum them up. So, let's break down the code, shall we?

## **Logic and Intuition:**
This code is designed to determine the beauty of all possible substrings of a given string and sum them up. The beauty of a substring is defined as the difference between the highest and lowest frequencies of characters in that substring.

### **1. `beautySum` function:**
- The outer two loops essentially generate all possible substrings of the string `s`. 
- For each of these substrings, the function `findBeauty` is called to determine its beauty.
- The result from each call is then added to the `beautySum`.

### **2. `findBeauty` function:**
- This function takes a substring and calculates its beauty. 
- It uses an array `temp` of size 26 (since there are 26 letters in the English alphabet) to store the frequency of each character in the substring.
- The line `temp[s.charAt(i) - 97]++` calculates the appropriate index for each character ('a' corresponds to 0, 'b' to 1, and so on) and increments the count for that character.
- After populating the `temp` array, we iterate through it to find the maximum and minimum frequencies, ignoring any character that doesn't appear in the substring (`temp[i] != 0`).
- The beauty of the substring is then returned as the difference between the maximum and minimum frequencies.

## **Why it works:**
- The logic behind calculating the beauty for each substring is sound because the frequency count method effectively captures the number of times each character appears in the substring.
- The approach to generate all possible substrings ensures that every potential section of the original string is evaluated.

## **Example:**
Consider the string `s = "abc"`. 
- Possible substrings are: "a", "ab", "abc", "b", "bc", and "c".
- For the substring "ab", the frequency of characters are: a=1, b=1. So, max=1 and min=1. The beauty is `max-min = 0`.
- For the substring "abc", the frequency of characters are: a=1, b=1, c=1. Again, the beauty is `max-min = 0`.
- However, for the substring "aa", the frequency of characters are: a=2. So, max=2 and min=2. The beauty is `max-min = 0`.

This process is repeated for every substring.

## **In essence:**
This program provides an elegant way to evaluate the "beauty" of each section of a string. It highlights a key strategy in problem-solving: breaking down the task into smaller, manageable functions (`beautySum` and `findBeauty`). The outer loops in `beautySum` ensure that every possible substring is considered, while the `findBeauty` function does the job of calculating the beauty of each individual substring.

Remember, class, always look for ways to modularize and simplify your code like this—it not only makes your code more readable but also easier to debug and maintain!
 */
