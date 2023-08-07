import java.util.Stack;

public class SumOfSubarrayMinimum {
   public int solve(int arr[]) {
      int prevSmaller[] = new int[arr.length];
      int nextSmaller[] = new int[arr.length];
      Stack<Integer> stack = new Stack<Integer>();
      int count = 0;
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         while (stack.size() > 0 && arr[stack.peek()] > arr[i]) {
            stack.pop();
         }
         if (stack.size() == 0) {
            prevSmaller[i] = 0;
         } else {
            prevSmaller[i] = stack.peek() + 1;
         }
         System.out.print(prevSmaller[i] + " , ");
         stack.push(count);
         count++;
      }
      count = n - 1;
      stack.clear();
      for (int i = n - 1; i >= 0; i--) {
         while (stack.size() > 0 && arr[stack.peek()] > arr[i]) {
            stack.pop();
         }
         if (stack.size() == 0) {
            nextSmaller[i] = n - 1;
         } else {
            nextSmaller[i] = stack.peek() - 1;
         }
         stack.push(count);
         count--;
      }
      System.out.println("");
      int ans = 0;
      for (int i = 0; i < n; i++) {
         System.out.print(nextSmaller[i] + " , ");
      }
      System.out.println("");
      for (int i = 0; i < n; i++) {
         int g1 = 0, g2 = 0;
         if (prevSmaller[i] == i) {
            g1 = -1;
            g2 = -1;
         } else if (nextSmaller[i] == i) {
            g2 = -1;
            g1 = -1;
         }
         g1 = g1 + i - prevSmaller[i] + 1;
         g2 = g2 + nextSmaller[i] - i + 1;
         System.out.println(g1 + " , " + g2);
         ans = ans + (g1 + g2 + 1) * arr[i];
      }
      System.out.println("");
      return ans;
   }

   public static void main(String[] args) {
      SumOfSubarrayMinimum obj = new SumOfSubarrayMinimum();
      int arr[] = { 72,40,83};
      System.out.println(obj.solve(arr));
   }
}
