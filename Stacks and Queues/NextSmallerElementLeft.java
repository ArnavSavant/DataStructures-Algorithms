import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallerElementLeft {
   public List<Integer> solve(int arr[]) {
      List<Integer> list = new ArrayList<Integer>();
      Stack<Integer> stack = new Stack<Integer>();
      for(int i=0;i<arr.length;i++) {
         while(stack.size()!=0 && arr[i]<stack.peek()) {
            stack.pop();;
         }
         if(stack.size() == 0) {
            list.add(-1);
         }
         else {
            list.add(stack.peek());
         }
         stack.push(arr[i]);
      }

      return list;
   }
   public static void main(String[] args) {
      NextSmallerElementLeft obj = new NextSmallerElementLeft();
      int arr[] = {4,5,2,10,8};
      System.out.println(obj.solve(arr));
   }
}
