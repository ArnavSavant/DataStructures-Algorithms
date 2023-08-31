public class Leetcode_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while(row<m && col>=0) {
            if(matrix[row][col]==target) {
                return true;
            }
            else if(matrix[row][col]>target) {
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}

/*
Ah, this code makes a reappearance! As the "greatest professor" at our illustrious Institute, I'd be delighted to expound upon it once more. The algorithm you've presented intends to search for a target value within a specialized 2D matrix. This matrix is characterized such that each row is sorted from left to right, and each column is sorted from top to bottom.

Let's deconstruct the algorithm:

### Pretext:

**Matrix Properties:**  
Given the structure of the matrix:

- The smallest number in any row is its first element.
- The largest number in any row is its last element.
- Every value to the right of a certain value (in the same row) is larger.
- Every value below a certain value (in the same column) is larger.

### Explanation:

**1. Matrix Dimensions:**  
Firstly, we determine the dimensions of our matrix:
```java
int m = matrix.length;      // number of rows
int n = matrix[0].length;   // number of columns
```

**2. Starting Point:**  
We initiate our search from the top-right corner of the matrix:
```java
int row = 0;
int col = n-1;
```

**3. Search Process:**  
With our starting point established, we enter a loop, remaining within the matrix boundaries:

- If the current element matches our target, victory! We return `true`:
```java
if(matrix[row][col]==target) {
    return true;
}
```

- If our current element overshoots the target, it suggests the target (if it exists) lies to the left. So, we move one column to the left:
```java
else if(matrix[row][col]>target) {
    col--;
}
```

- If our current element is less than the target, it intimates the target resides below. Thus, we progress one row downward:
```java
else {
    row++;
}
```

**4. Conclusion of Search:**  
If we've traipsed the entire matrix (reaching beyond the last row or the first column) without discovering the target, it implies the target is absent. Consequently, we return `false`:
```java
return false;
```

### Logic & Intuition:

Imagine you are standing at the top-right corner of the matrix, and you wish to locate a certain number. Now, due to the matrix's structure:

- If your current number is too large, you know you must head left to seek smaller numbers.
- If it's too small, heading downward will guide you to larger numbers.

In essence, you're traversing a path, with each step giving you a clear direction based on the matrix's sorted characteristics. The process continues until you either locate your number or confirm its absence. This methodology takes advantage of the matrix's unique layout to execute an efficient search, eliminating a sizable portion of the matrix with each step.

The genius of this algorithm lies in its simplicity. Instead of engaging in a convoluted binary search on a 2D plane, it offers a linear yet efficient way to home in on the target by understanding and leveraging the matrix's properties.
 */
