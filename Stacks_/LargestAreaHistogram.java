import java.util.Stack;

public class LargestAreaHistogram {
   public int solve(int arr[]) {
      int width[] = new int[arr.length];
      int left[] = new int[arr.length];
      int right[] = new int[arr.length];

      Stack<Integer> stack = new Stack<Integer>();
      for (int i = 0; i < arr.length; i++) {
         while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
            stack.pop();
         }
         if (stack.size() == 0) {
            left[i] = 0;
         } else {
            left[i] = stack.peek() + 1;
         }
         stack.push(i);
      }

      stack.clear();
      
      for (int i = arr.length - 1; i >= 0; i--) {
         while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
            stack.pop();
         }
         if (stack.size() == 0) {
            right[i] = arr.length - 1;
         } else {
            right[i] = stack.peek() - 1;
         }
         stack.push(i);
      }
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
         width[i] = (right[i] - left[i] + 1) * arr[i];
         max = Math.max(max, width[i]);
      }
      return max;
   }

   public static void main(String[] args) {
      LargestAreaHistogram obj = new LargestAreaHistogram();
      // int arr[] = { 1, 4, 10, 7, 6, 3, 8, 9, 5, 11, 10 };
      int arr[] = { 1, 1, 1 };
      // int arr[] = {6,2,5,4,5,1,6};
      System.out.println(obj.solve(arr));
   }
}
