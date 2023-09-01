public class Leetcode_5 {
    public String longestPalindrome(String s) {
        char arr[] = preprocess(s);
        int P[] = new int[arr.length];
        int c = 0;
        int r = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int iMirror = 2 * c - i;
            if (r > i) {
                P[i] = Math.max(0, Math.min(r - i, P[iMirror]));
            }

            while (arr[i + 1 + P[i]] == arr[i - 1 - P[i]]) {
                P[i]++;
            }

            if (i + P[i] > r) {
                c = i;
                r = i + P[i];
            }
        }
        int centreIndex = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < P.length; i++) {
            if (P[i] > maxLen) {
                centreIndex = i;
                maxLen = P[i];
            }
        }
        return s.substring((centreIndex - maxLen) / 2, (centreIndex + maxLen) / 2);
    }

    public char[] preprocess(String s) {
        char[] arr = new char[2 * s.length() + 3];
        arr[0] = '@'; // start placeholder
        for (int i = 0; i < s.length(); i++) {
            arr[2 * i + 1] = '#';
            arr[2 * i + 2] = s.charAt(i);
        }
        arr[2 * s.length() + 1] = '#';
        arr[2 * s.length() + 2] = '$'; // end placeholder
        return arr;
    }
}

/*
Absolutely! This code is an implementation of Manacher's algorithm to find the longest palindromic substring in a given string `s`. Let's break it down step-by-step.

### Preprocess Function

```java
private char[] preprocess(String s) {
    char[] arr = new char[s.length() * 2 + 3];
    arr[0] = '@';
    arr[s.length() * 2 + 2] = '$';
    for (int i = 0; i < s.length(); i++) {
        arr[2 * i + 1] = '#';
        arr[2 * i + 2] = s.charAt(i);
    }
    arr[s.length() * 2 + 1] = '#';
    return arr;
}
```

**What it does:** The function converts the input string into another string (represented as an array of characters) that is easier to handle for the main algorithm. This new string has the following properties:

1. It has `#` characters interspersed between the characters of the original string.
2. It starts with an `@` character and ends with a `$` character. Both of these characters are not found in the original string. 

**Why:** By adding the '#' characters, every character in the original string has an explicit center. The '@' and '$' characters are guards to prevent boundary overflow issues.

For example: `"abba"` becomes `"@#a#b#b#a#$"`.

### Main Function

The main function is where the magic happens. Let's examine it part by part:

1. **Initialization**:
```java
if (s == null || s.length() == 0) return "";
char[] arr = preprocess(s);
int N = arr.length;
int[] P = new int[N];
int C = 0, R = 0;
```
Here, we first handle edge cases where the string is empty. Next, we preprocess the string and initialize the palindrome radius array `P`, and two pointers `C` (center of the palindrome currently known to include a boundary) and `R` (the right boundary of this palindrome).

2. **Manacher's Algorithm Loop**:
```java
for (int i = 1; i < N - 1; i++) {
    int iMirror = 2 * C - i;
    if (R > i) {
        P[i] = Math.min(R - i, P[iMirror]);
    }

    while (arr[i + 1 + P[i]] == arr[i - 1 - P[i]]) {
        P[i]++;
    }

    if (i + P[i] > R) {
        C = i;
        R = i + P[i];
    }
}
```
In this section:
- `iMirror` is the corresponding position of `i` about the center `C`.
- If `i` is inside the palindrome centered at `C`, we use the property of symmetry to infer the length of the palindrome centered at `i` (but, we need to ensure it doesn't go beyond the known boundary `R`).
- The `while` loop tries to expand the palindrome at the current center `i`.
- If the palindrome at `i` goes beyond `R`, we update `C` and `R`.

3. **Extracting the Result**:
```java
int maxLen = 0;
int centerIdx = 0;
for (int i = 1; i < N - 1; i++) {
    if (P[i] > maxLen) {
        maxLen = P[i];
        centerIdx = i;
    }
}
return s.substring((centerIdx - maxLen) / 2, (centerIdx + maxLen) / 2);
```
Here, we loop through the palindrome radius array `P` to find the palindrome with the maximum length (which is stored in `maxLen`). `centerIdx` is the center of this palindrome. Finally, we extract and return this palindrome from the original string.

**Summary:** The code efficiently finds the longest palindromic substring in the given string using Manacher's algorithm. The preprocessing step makes it easier to handle odd and even-length palindromes uniformly. The main function then uses properties of palindrome symmetry to quickly identify palindrome lengths at each center in the preprocessed string.
 */
