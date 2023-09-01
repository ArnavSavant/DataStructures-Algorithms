public class Leetcode_13 {
    public int romanToInt(String s) {
        int num = 0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            char x = s.charAt(i);
            if (x == 'M') {
                num = num + 1000;
            } else if (x == 'D') {
                num = num + 500;
            } else if (x == 'C') {
                if (i < n - 1 && s.charAt(i + 1) == 'M') {
                    num = num + 900;
                    i++;
                } else if (i < n - 1 && s.charAt(i + 1) == 'D') {
                    num = num + 400;
                    i++;
                } else {
                    num = num + 100;
                }
            } else if (x == 'L') {
                num = num + 50;
            } else if (x == 'X') {
                if (i < n - 1 && s.charAt(i + 1) == 'C') {
                    num = num + 90;
                    i++;
                } else if (i < n - 1 && s.charAt(i + 1) == 'L') {
                    num = num + 40;
                    i++;
                } else {
                    num = num + 10;
                }
            } else if (x == 'V') {
                num = num + 5;
            } else if (x == 'I') {
                if (i < n - 1 && s.charAt(i + 1) == 'X') {
                    num = num + 9;
                    i++;
                } else if (i < n - 1 && s.charAt(i + 1) == 'V') {
                    num = num + 4;
                    i++;
                } else {
                    num = num + 1;
                }
            }
            i++;
        }
        return num;
    }
}

/*
Ah, the Romans! Their numeral system, while poetic in its own right, poses challenges to the modern computational mind. But with a touch of understanding, one can master its intricacies. Let us delve deep into this piece of code that treads on the journey from Roman numerals to the integers we're so fond of.

### Problem Understanding:
This function aims to convert a Roman numeral string representation into its corresponding integer value.

### The Fundamentals:
- Roman numerals use combinations of letters from the Latin alphabet to signify values. The basic symbols are:
    - I (1)
    - V (5)
    - X (10)
    - L (50)
    - C (100)
    - D (500)
    - M (1000)

- Romans employed a subtractive notation for numbers like 4 (IV) and 9 (IX). Here, a smaller number precedes a larger number, indicating subtraction. So, IV means 5 - 1 = 4. Similarly,
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.

### Code Logic:

1. **Initialization**:
    - `num` is the final integer value we are calculating. Initialized to 0.
    - `i` is the current index of the string we are processing.

2. **Traversal**:
    - We iterate over the string `s` character by character.

3. **Character Interpretation**:
    - For each character in `s`, we check its value:
        - If it's `M`, add 1000 to `num`.
        - If it's `D`, add 500 to `num`.
        - ... and so forth.

4. **Special Cases (Subtractive Notation)**:
    - If the current character is `C` and the next one is `M`, it means 900 (1000 - 100). We add 900 to `num` and increase the index `i` by one more to skip the next character, as we've already accounted for it.
    - Similar logic applies for `CD`, `XC`, `XL`, `IX`, and `IV`.

5. **Continuation**:
    - After dealing with each character, we increment the index `i` and proceed.

6. **End Result**:
    - At the end of the traversal, `num` holds the integer representation of the Roman numeral. This is returned.

### Intuition:

Imagine you're reading an ancient Roman scroll. As you read each symbol from left to right, you keep adding its value to a treasure chest (`num`). However, every time you stumble upon certain pairs of symbols, you realize you've added a bit too much! So, you adjust accordingly. By the time you've finished reading the scroll, your treasure chest has the exact amount the Romans intended.

This function is that careful reader, ensuring every symbol is treated with the respect and attention it deserves.

In conclusion, the code takes an intuitive approach to the Roman numeral system. It adds values for each numeral and adjusts for the Roman's unique subtractive notation, ensuring accurate translation to our modern integer system.
 */
