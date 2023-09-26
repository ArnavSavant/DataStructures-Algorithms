import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
   public List<Integer> solve(int price[]) {
      List<Integer> list = new ArrayList<Integer>();
      Stack<Integer> stack = new Stack<Integer>();
      int count = 0;
      for(int i=0;i<price.length;i++) {
         while(stack.size()!=0 && stack.peek()<=price[i]) {
            stack.pop();
            count++;
         }
         stack.push(price[i]);
         count++;
         list.add(count);
         count--;
      }
      return list;
   }
   public static void main(String[] args) {
      StockSpan obj = new StockSpan();
      int price[] = {100,80,60,70,60,60,75,85};
      System.out.println(obj.solve(price));
   }
}