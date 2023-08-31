import java.util.Scanner;

public class Leetcode_151 {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        s.trim();
        Scanner sc = new Scanner(s);
        while (sc.hasNext()) {
            ans.insert(0, sc.next());
            ans.insert(0, " ");
        }
        ans = ans.deleteCharAt(0);
        sc.close();
        return ans.toString();
    }
}
/*
Ah, we're delving into the intricacies of string manipulation! This code's primary function is to reverse the order of words in a given string `s`. Let's go through it step by step:

## Code Explanation:

1. Initialize a StringBuilder:
```java
StringBuilder ans = new StringBuilder();
```
A `StringBuilder` is used here because it allows for more efficient manipulation of strings compared to using string concatenation.

2. Trim the input string:
```java
s.trim();
```
This line removes any leading or trailing whitespace from the string `s`. However, this line has a slight issue. The result of `s.trim()` is not assigned back to `s`, which means the trimming has no effect on subsequent operations. The correct line should be: 
```java
s = s.trim();
```

3. Initialize a Scanner with the string:
```java
Scanner sc = new Scanner(s);
```
The `Scanner` class in Java is commonly used for parsing input. Here, it's utilized to break the string into individual words.

4. While there are more words in the string:
```java
while (sc.hasNext()) {
```
The `hasNext()` method checks if the scanner has another word in its input.

5. Insert the next word at the beginning of the StringBuilder:
```java
ans.insert(0, sc.next());
```
The `sc.next()` fetches the next word from the scanner, and `ans.insert(0, ...)` inserts this word at the beginning of the StringBuilder.

6. Insert a space character at the beginning of the StringBuilder:
```java
ans.insert(0, " ");
```
This space is placed before every new word added to the beginning. This results in an extra space at the start, which is removed in the next step.

7. After the loop completes, there's an extra space at the beginning. It's removed with:
```java
ans = ans.deleteCharAt(0);
```
This deletes the character at the specified index, which is `0` in this case.

8. Close the scanner to release resources:
```java
sc.close();
```

9. Convert the StringBuilder back to a String and return:
```java
return ans.toString();
```

## Logic and Intuition:

Imagine you're given a stack of word cards and are asked to stack them in reverse order. With each word from the original order, you'd place it at the bottom of your new stack, pushing the previously placed cards up. This is essentially what the code is doing.

Using a `Scanner`, the function processes each word in the original order, but rather than appending each word to the end (as you'd normally do), it inserts each word at the beginning of the `StringBuilder`. This effectively reverses the order of words by the time the entire string is processed.

The use of `StringBuilder` and its `insert` method is crucial to the efficiency of this operation. If you tried to do this with regular string concatenation, it would be considerably less efficient because strings in Java are immutable; thus, every concatenation would create a new string object.

In conclusion, this function effectively reverses the order of words in a string by processing each word and placing it at the beginning of the resulting string. It's a neat exercise in string manipulation and demonstrates the importance of using efficient tools like `StringBuilder` for such operations.
 */
