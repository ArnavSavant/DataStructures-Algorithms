import java.util.Stack;

public class Leetcode_503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans[] = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}
/*
Alright, let's break this down.

The problem tackled here is the Next Greater Element II. In this problem, given a circular array (the next element of the last element is the first element of the array), we need to find the next greater element for every element. If it doesn't exist, output `-1` for that element. The circular nature means that we can wrap around the end of the array to its beginning.

### Logic and Intuition:

1. **Stack's Role**: 
   The stack is used to keep track of the indices of the elements. When processing a new element, the stack can help determine if the current element is the "next greater" element for the elements in the stack.

2. **Circular Nature**: 
   Due to the circular nature of the problem, we need to traverse the array twice. The first pass is to get the next greater element in the current sequence, and the second pass is to account for the circular nature and find the next greater element for the remaining numbers.

3. **Stack Pop and Push**: 
   When iterating over the numbers, if the current number is greater than the number at the index represented by the top of the stack, then the current number is the "next greater" number for the numbers represented in the stack (until a number greater than the current number is found).

### Step-by-step Explanation:

1. **Initialization**:
   - A stack is initialized to keep track of elements.
   - An array `ans` is initialized to store the results for each number.

2. **First Pass** (handles the next greater element in the current sequence):
   - Traverse the numbers in reverse. For each number:
     - If the stack is empty, `-1` is stored as the result since there's no next greater number.
     - If the stack is not empty and the top of the stack is less than or equal to the current number, the stack's top is popped (meaning this number is not the next greater number for the current element).
     - After the popping, if the stack becomes empty, then `-1` is the result; otherwise, the top of the stack is the next greater number.
     - The current number is then pushed onto the stack.

3. **Second Pass** (handles the circular nature):
   - This pass is almost identical to the first pass but is meant to handle numbers for which we haven't found the next greater number in the first pass.
   - Since the array is circular, this pass ensures that for elements at the start of the array, their next greater elements towards the end of the array are considered.

### Why This Code Works:

1. **Stack Memory**:
   By storing elements in the stack, we're essentially remembering the numbers for which we haven't found the next greater element yet.

2. **Two Passes**:
   The circular nature is addressed by traversing the array twice. The first pass might not find the next greater number for some elements (especially those at the start of the array), but the second pass ensures those elements get their next greater numbers if they exist.

3. **Efficiency**:
   Even though we traverse the array twice and use a while loop inside the for loop, each element is pushed and popped from the stack at most once. Therefore, the time complexity is linear.

In summary, this code uses a stack to efficiently track and find the next greater element in a circular array by leveraging the properties of stacks and the nature of the problem.
 */
