import java.util.Stack;

public class MinStackWithoutExtraSpace {
   Stack<Integer> stack = new Stack<Integer>();
   int min;

   public MinStackWithoutExtraSpace() {
      min = Integer.MAX_VALUE;
   }

   public void push(int val) {
      if (stack.size() == 0) {
         stack.push(val);
         min = val;
      } else {
         if (val >= min) {
            stack.push(val);
         } else {
            stack.push((2 * val) - min);
            min = val;
         }
      }
   }

   public void pop() {
      if (stack.peek() <= min) {
         min = (2 * min) - stack.peek();
      }
      stack.pop();

   }

   public int top() {
      if (stack.peek() < min) {
         return min;
      } else {
         return stack.peek();
      }
   }

   public int getMin() {
      return min;
   }
   public static void main(String[] args) {
      MinStackWithoutExtraSpace obj = new MinStackWithoutExtraSpace();
      obj.push(2147483646);
      obj.push(2147483646);
      obj.push(2147483647);
      obj.top();
   }
}
