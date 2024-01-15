import java.util.Arrays;

public class Leetcode_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int arr[] = new int[n];
        int candyRequired = 0;
        Arrays.fill(arr, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1] && arr[i] <= arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
        }
        for (int x : arr) {
            candyRequired = candyRequired + x;
        }
        return candyRequired;
    }
}
/*
The Java method `candy(int[] ratings)` is designed to solve a problem often encountered in algorithm design, particularly related to greedy algorithms. The problem is to assign candies to children standing in a line such that each child must have at least one candy, and children with a higher rating get more candies than their immediate neighbors.

### 1. **Code Explanation**

- **Initialization**:
  - `n`: The number of children (or length of the `ratings` array).
  - `arr`: An array to store the number of candies each child receives. Initially, each child is assigned one candy.
  - `candyRequired`: A variable to sum up the total number of candies needed.

- **First Pass (Left to Right)**:
  - Iterates over the `ratings` array from left to right.
  - If a child has a higher rating than the child to their left, they receive one more candy than that child.

- **Second Pass (Right to Left)**:
  - Iterates over the `ratings` array from right to left.
  - If a child has a higher rating than the child to their right and doesn't already have more candies, they receive one more candy than that child.

- **Summing Up Candies**:
  - Iterates over the `arr` array to sum up the total number of candies.

### 2. **Logic of the Code**
The logic of this code is based on the greedy algorithm, ensuring each child has more candies than their immediate neighbors with a higher rating. The two-pass approach (first left to right, then right to left) ensures that both sides' conditions are satisfied.

### 3. **Developing Intuition and Identifying Correct Approaches**
- **Recognizing Problem Patterns**: This is a classic problem that requires satisfying local conditions (ratings compared to immediate neighbors) to achieve a global goal (minimum total candies).
- **Algorithm Choice**: A greedy algorithm with a two-pass approach efficiently solves the problem by ensuring all local conditions are met.

### 4. **Why the Code Works**
- **Two-Pass Approach**: The first pass ensures that each child has more candies than the child to their left if they have a higher rating. The second pass does the same for the right side.
- **Greedy Local Decisions**: At each step, the algorithm makes a local decision (assigning one more candy) that leads to a globally optimal solution.

### 5. **Time and Space Complexity Calculations**
- **Time Complexity**: 
  - The algorithm involves three separate linear passes through the `ratings` array, so the time complexity is O(3n), which simplifies to O(n).
- **Space Complexity**:
  - The space complexity is O(n) due to the additional array `arr` used to store the candy count for each child.

In summary, this method is an effective solution to the candy distribution problem, utilizing a two-pass greedy algorithm to satisfy the local conditions and achieve a globally optimal solution.
 */