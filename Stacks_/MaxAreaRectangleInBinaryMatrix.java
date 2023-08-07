import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {
   public int solve(int arr[][]) {
      int max = Integer.MIN_VALUE;
      int histogram[] = new int[arr[0].length];
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] == 1) {
               histogram[j] = histogram[j] + 1;
            } else {
               histogram[j] = 0;
            }
         }
         max = Math.max(max, maximumAreaHistogram(histogram));
      }
      return max;
   }

   public int maximumAreaHistogram(int arr[]) {
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
      MaxAreaRectangleInBinaryMatrix obj = new MaxAreaRectangleInBinaryMatrix();
      int arr[][] = { { 0, 1, 1, 0 }, 
                     { 1, 1, 1, 1 }, 
                     { 1, 1, 1, 1 }, 
                     { 1, 1, 0, 0 } };
      System.out.println(obj.solve(arr));
   }
}
