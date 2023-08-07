import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementLeft {
   public List<Integer> solve(int arr[]) {
      Stack<Integer> stack = new Stack<Integer>();
      List<Integer> list = new ArrayList<Integer>();
      for (int i = 0; i < arr.length; i++) {
         while (stack.size() != 0 && arr[i] > stack.peek()) {
            stack.pop();
         }
         if (stack.size() == 0) {
            list.add(-1);
         } else {
            list.add(stack.peek());
         }
         stack.push(arr[i]);
      }
      return list;
   }

   public static void main(String[] args) {
      NextGreaterElementLeft obj = new NextGreaterElementLeft();
      int arr[] = { 1, 4, 10, 7, 6, 3, 8, 9, 5, 11, 10 };
      System.out.println(obj.solve(arr));
   }
}
