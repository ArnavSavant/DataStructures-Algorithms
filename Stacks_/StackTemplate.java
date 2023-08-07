public class StackTemplate {
   int stack[];
   int top;
   int length;

   StackTemplate(int size) {
      this.stack = new int[size];
      this.top = -1;
      this.length = 0;
   }

   public void push(int element) {
      if (!isFull()) {
         stack[++top] = element;
         length++;
      }
      return;
   }

   public int pop() {
      if (!isEmpty()) {
         length--;
         return stack[top--];
      }
      return -1;
   }

   public boolean isEmpty() {
      return (top == -1) ? true : false;
   }

   public boolean isFull() {
      return (top == stack.length - 1) ? true : false;
   }
}
