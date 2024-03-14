import java.util.ArrayList;
import java.util.List;

public class Leetcode_1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            int i = 0;
            int j = 0;
            while (i < query.length() && j < pattern.length()) {
                if (query.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else if (query.charAt(i) >= 'a' && query.charAt(i) <= 'z') {
                    i++;
                } else {
                    break;
                }
            }
            while (i < query.length()) {
                if (query.charAt(i) >= 'a' && query.charAt(i) <= 'z') {
                    i++;
                } else {
                    break;
                }
            }
            if (i == query.length() && j == pattern.length()) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
/*
### Documentation for the `camelMatch` Method

#### Logic of the Code

The `camelMatch` method determines if each query string in a given array of strings matches a specified pattern. The matching criteria are based on camel case convention, where:
- A query matches the pattern if it contains all the characters in the pattern in the same order.
- Additional lowercase letters can be present in the query but not additional uppercase letters.

The method follows these steps for each query:
1. **Initialization**: Two pointers (`i` and `j`) are initialized to track the current character in the query and the pattern, respectively.
2. **Character Matching**: The method iterates through the characters of the query and the pattern simultaneously, incrementing both pointers when a character matches. If a character in the query does not match the current character in the pattern but is lowercase, the pointer in the query is incremented to skip this character. If the character is uppercase and does not match, the iteration breaks early.
3. **Skipping Remaining Lowercase Letters**: After either reaching the end of the pattern or a non-matching uppercase letter in the query, the method continues to iterate through the remaining characters in the query. It skips any lowercase letters. If an uppercase letter is encountered, the iteration breaks early.
4. **Result Determination**: If the end of both the query and the pattern is reached simultaneously, it indicates a match, and `true` is added to the result list. Otherwise, `false` is added.

#### Intuition to Develop This Logic/Approach

The intuition behind this approach is to leverage the camel case naming convention to check pattern matching. By using two pointers, the method efficiently traverses the query and the pattern, ensuring that all characters in the pattern are present in the query in the correct order while allowing for additional lowercase letters. This approach directly applies the camel case matching rules to determine if the query strings adhere to the specified pattern.

#### Why This Code Works

This code effectively identifies matching queries because it accurately implements the camel case matching criteria by:
- Ensuring that all characters in the pattern are present in the query in the same order.
- Allowing for additional lowercase letters in the query but not additional uppercase letters, in line with camel case convention.
- Properly handling the end of the pattern and the query to determine a match.

#### Time and Space Complexities

- **Time Complexity**: The time complexity of this method is O(n*m), where n is the number of queries and m is the average length of the queries. This is because, for each query, the method iterates through the characters in the query and, in the worst case, checks each character against the pattern.
  
- **Space Complexity**: The space complexity is O(n), where n is the number of queries, as the method stores the result of each query match check in a list. The space used by pointers and counters is constant and does not scale with the input size.

The `camelMatch` method efficiently determines if queries match a given pattern following camel case rules, providing a straightforward and effective solution to the problem.
 */