import java.util.HashMap;
import java.util.Map;

public class Leetcode_860 {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> change = new HashMap<>();
        Boolean isPossible = true;
        change.put(5, 0);
        change.put(10, 0);
        for (int b : bills) {
            if (b == 5) {
                change.put(5, change.get(5) + 1);
            } else if (b == 10) {
                change.put(10, change.get(10) + 1);
                if (change.get(5) > 0) {
                    change.put(5, change.get(5) - 1);
                } else {
                    isPossible = false;
                    break;
                }
            } else {
                if (change.get(10) > 0 && change.get(5) > 0) {
                    change.put(5, change.get(5) - 1);
                    change.put(10, change.get(10) - 1);
                } else if (change.get(5) > 2) {
                    change.put(5, change.get(5) - 3);
                } else {
                    isPossible = false;
                    break;
                }
            }
        }
        return isPossible;
    }
}
/*
 * ### Problem Description:
 * 
 * The code is implementing a solution to the "Lemonade Change" problem. In this
 * problem, a lemonade stand sells lemonade for $5, $10, and $20 bills. The goal
 * is to determine whether the lemonade stand can provide change for each
 * customer, given that each customer pays with only $5, $10, or $20 bills.
 * 
 * ### Code Explanation:
 * 
 * 1. **Initialization:**
 * - A `Map<Integer, Integer>` called `change` is used to keep track of the
 * count of $5 and $10 bills available for providing change.
 * - A boolean variable `isPossible` is initialized as `true`.
 * 
 * 2. **Processing Bills:**
 * - The code iterates through each bill in the `bills` array.
 * - For each bill, it checks the denomination and updates the `change` map
 * accordingly.
 * 
 * 3. **Handling $5 Bills:**
 * - If the bill is $5, the count of $5 bills in the `change` map is
 * incremented.
 * 
 * 4. **Handling $10 Bills:**
 * - If the bill is $10, the count of $10 bills in the `change` map is
 * incremented.
 * - If there is at least one $5 bill available, it is used for change, and the
 * count is decremented. Otherwise, it sets `isPossible` to `false` and breaks
 * the loop.
 * 
 * 5. **Handling $20 Bills:**
 * - If the bill is $20, the code tries to use one $10 bill and one $5 bill for
 * change.
 * - If there are not enough $10 bills, it tries to use three $5 bills.
 * - If both options fail, it sets `isPossible` to `false` and breaks the loop.
 * 
 * 6. **Final Result:**
 * - The method returns the final value of `isPossible`, indicating whether the
 * lemonade stand can provide change for all customers.
 * 
 * ### Logic and Intuition:
 * 
 * - The algorithm simulates the process of providing change for each customer
 * based on their bill denomination.
 * - It uses a `Map` to keep track of available $5 and $10 bills.
 * - The logic ensures that the lemonade stand can provide change for each
 * customer based on the available bills.
 * 
 * ### Why this Code Works:
 * 
 * - The code handles each bill denomination separately, updating the count of
 * available bills for change.
 * - It ensures that the lemonade stand only provides change if there are enough
 * $5 and $10 bills available.
 * - The use of a `Map` allows for efficient tracking of the count of each bill
 * denomination.
 * 
 * ### Time and Space Complexity:
 * 
 * - **Time Complexity:**
 * - The code iterates through each bill once, resulting in O(n) time
 * complexity, where n is the length of the `bills` array.
 * 
 * - **Space Complexity:**
 * - The space complexity is O(1) since the `change` map has a fixed number of
 * entries (5 and 10).
 * 
 * ### Summary:
 * 
 * The code effectively solves the "Lemonade Change" problem by simulating the
 * process of providing change based on the bill denominations. It maintains a
 * count of available $5 and $10 bills and ensures that change is provided only
 * when sufficient bills are available. The time complexity is linear, and the
 * space complexity is constant.
 */