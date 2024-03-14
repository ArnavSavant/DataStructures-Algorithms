public class Leetcode_2864 {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                sb.append('1');
                count++;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        count = n - count;
        while (count > 0) {
            sb.append('0');
            count--;
        }
        sb.append('1');
        return sb.toString();
    }
}
/*
 * ### Documentation for the `maximumOddBinaryNumber` Method
 * 
 * #### Logic of the Code
 * 
 * The `maximumOddBinaryNumber` method transforms a binary string to the largest
 * possible odd binary number by rearranging its digits. It follows these steps:
 * 
 * 1. **Count 1s and Construct Initial String**: It iterates through the input
 * string `s`, counting the number of '1's and simultaneously building a new
 * string that includes all the '1's from the input.
 * 2. **Adjust for Oddness**: It removes the last '1' added to the new string to
 * ensure the final number can be made odd. This step is crucial because the
 * method aims to construct the maximum odd binary number.
 * 3. **Append 0s**: It then calculates the number of '0's in the original
 * string (which is the length of the original string minus the count of '1's)
 * and appends all these '0's to the new string. This step ensures that all the
 * digits from the original string are used but rearranged.
 * 4. **Ensure Oddness**: Finally, it appends a '1' to the end of the new
 * string. This step guarantees that the resultant binary number is odd, as any
 * binary number ending in '1' is odd.
 * 
 * #### Intuition to Develop This Logic/Approach
 * 
 * The intuition behind this approach is based on two observations:
 * 
 * 1. **Maximizing the Value**: To maximize a binary number, we need to place
 * all '1's as left as possible because in binary, the leftmost digits
 * contribute more to the overall value.
 * 2. **Ensuring Oddness**: A binary number is odd if it ends in '1'. Hence, to
 * make the largest odd binary number, we need to ensure that after placing all
 * '1's to the left, the number should end with a '1'.
 * 
 * This logic cleverly rearranges all '1's to the left while ensuring the result
 * is odd, thereby achieving the goal with minimal computational steps.
 * 
 * #### Why This Code Works
 * 
 * This code works because it leverages the binary number system's properties to
 * rearrange the digits optimally. By ensuring all '1's are placed to the left,
 * the method maximizes the binary number's value. Removing one '1' and then
 * appending it at the end after all '0's ensures that the binary number is odd,
 * fulfilling the method's objective. The careful counting and rearrangement
 * guarantee that all original digits are used, preserving the original number's
 * length.
 * 
 * #### Time and Space Complexities
 * 
 * - **Time Complexity**: The time complexity of this method is O(n), where n is
 * the length of the input string. This is because it iterates over the string
 * once to count '1's and build the initial part of the new string, and then
 * possibly iterates over the length of the string again to append '0's and the
 * final '1'.
 * 
 * - **Space Complexity**: The space complexity is O(n) as well, due to the
 * usage of a `StringBuffer` to construct the new binary string. The size of
 * this buffer grows linearly with the size of the input string.
 * 
 * This method is efficient and practical for transforming binary strings into
 * their maximum odd binary number equivalent, using a straightforward approach
 * that leverages the fundamental properties of binary numbers.
 */