import java.util.ArrayList;
import java.util.List;

public class Leetcode_118 {
   public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> list = null;
      List<Integer> prev = null;
      for (int i = 0; i < numRows; i++) {
         list = new ArrayList<Integer>();
         for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i) {
               list.add(1);
            } else {
               list.add(prev.get(j - 1) + prev.get(j));
            }
         }
         result.add(list);
         prev = list;
      }
      return result;
   }
}

/*
### Pascal's Triangle
Pascal's Triangle is a mathematical concept where each number is the sum of the two numbers directly above it. Here's an example of the first five rows:

```
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
```

### Code Explanation

1. **Initialization**: The code initializes a `result` list to hold the entire triangle and two other lists, `list` and `prev`, to hold the current and previous rows, respectively.

2. **Outer Loop**: The outer loop (`for (int i = 0; i < numRows; i++)`) iterates through the number of rows specified by `numRows`.

3. **Inner Loop**: The inner loop (`for (int j = 0; j <= i; j++)`) iterates through each element of the current row `i`.

   - **First and Last Elements**: If `j` is 0 or equal to `i` (first or last element of the row), the code adds 1 to the `list`. This corresponds to the fact that the first and last elements of any row in Pascal's Triangle are always 1.
   - **Middle Elements**: For other elements, the code adds the sum of the corresponding elements from the previous row (`prev.get(j - 1) + prev.get(j)`). This is the core logic of Pascal's Triangle, where each number is the sum of the two numbers directly above it.

4. **Adding the Row**: After constructing the row, the code adds it to the `result` and updates `prev` to point to the current `list`. This ensures that the next iteration can access the current row when calculating the next one.

5. **Returning the Result**: Finally, the code returns the `result`, which contains the entire Pascal's Triangle up to `numRows`.

### Why It Works
The code works because it follows the mathematical rules of Pascal's Triangle. By iteratively building each row based on the previous one and handling the special cases for the first and last elements, it accurately constructs the triangle.

The use of the `prev` list to keep track of the previous row is a clever way to access the required values without needing to reference the entire triangle. This makes the code more efficient and aligns with the mathematical definition of Pascal's Triangle.

 */
