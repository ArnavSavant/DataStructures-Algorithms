import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextSmallerElementRight {
   public List<Integer> solve(int arr[]) {
      List<Integer> list = new ArrayList<Integer>();
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = arr.length - 1; i >= 0; i--) {
         while (stack.size() != 0 && arr[i] < stack.peek()) {
            stack.pop();
         }
         if (stack.size() == 0) {
            list.add(-1);
         } else {
            list.add(stack.peek());
         }
         stack.push(arr[i]);
      }
      Collections.reverse(list);
      return list;
   }

   public static void main(String[] args) {
      NextSmallerElementRight obj = new NextSmallerElementRight();
      int arr[] = { 4, 5, 2, 10, 8 };
      System.out.println(obj.solve(arr));
   }
}