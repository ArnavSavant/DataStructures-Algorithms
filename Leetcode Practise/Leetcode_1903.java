public class Leetcode_1903 {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--) {
            if(Integer.parseInt(num.charAt(i)+"")%2==1) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}

/*
 Ah, an intriguing snippet! Let's dissect it.

### Purpose:
The function `largestOddNumber` aims to extract the largest odd number by truncating the input string `num` from the right. If no odd number can be formed, it returns an empty string.

### Logic & Intuition:

**1. Starting Point:**
The loop starts from the last character of the string and moves to the beginning. Why? The largest number that can be made by truncating digits will be obtained by removing as few digits as possible. So, we need to find the rightmost odd digit.

**2. Oddness Check:**
The check `Integer.parseInt(num.charAt(i)+"")%2==1` is determining if the current character is an odd number.

Here's the breakdown of that check:
- `num.charAt(i)` fetches the character at position `i` in the string `num`.
- `num.charAt(i) + ""` converts the character to a string.
- `Integer.parseInt(...)` converts that string back to an integer. This might seem like an unnecessary conversion, but it's essential to treat the character as its numeric value rather than its ASCII value.
- `%2 == 1` checks if the number is odd.

**3. Truncation:**
If an odd number is found, the substring from the start to the current index is returned using `num.substring(0, i+1)`. This effectively truncates all digits to the right of the current odd number.

**4. Fallback Return:**
If the loop completes without finding an odd number, it means there's no odd digit in the input string. Thus, the function returns an empty string.

### Why it works:
The logic is grounded in the properties of odd numbers. For an integer to be odd, its least significant digit (i.e., its rightmost digit) must be odd. So, to find the largest odd number, we look for the rightmost odd digit and truncate the number at that position. This way, we preserve as much of the number's magnitude as possible while ensuring it's odd.

### Example:
Take the string "4206". Here's how the function processes this string:

1. Start at '6' - Not odd, move left.
2. Examine '0' - Not odd, move left.
3. Examine '2' - Not odd, move left.
4. Examine '4' - Not odd, move left.

The loop concludes without finding an odd digit, so the function returns an empty string.

But for "4205":

1. Start at '5' - Odd! So, return "4205".

In essence, this code adeptly identifies the largest odd number by smartly truncating unnecessary rightmost even digits.
 */