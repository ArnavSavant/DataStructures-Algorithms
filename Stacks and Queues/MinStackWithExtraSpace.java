import java.util.Stack;

public class MinStackWithExtraSpace {
   Stack<Integer> stack1 = new Stack<Integer>();
   Stack<Integer> stack2 = new Stack<Integer>();
   int min;

   public MinStackWithExtraSpace() {
      min = Integer.MAX_VALUE;
   }

   public void push(int val) {
      stack1.push(val);
      if (stack2.size() == 0) {
         stack2.push(val);
      } else {
         stack2.push(Math.min(stack2.peek(), val));
      }
   }

   public void pop() {
      stack1.pop();
      stack2.pop();
   }

   public int top() {
      return stack1.peek();
   }

   public int getMin() {
      return stack2.peek();
   }
}
