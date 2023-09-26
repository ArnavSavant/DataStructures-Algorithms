import java.util.*;

class Node<T> {
   T data;
   Node<T> next;

   public Node(T data) {
      this.data = data;
      this.next = null;
   }
}

class Stack<T> {
   private Node<T> top;

   public Stack() {
      top = null;
   }

   public boolean isEmpty() {
      return top == null;
   }

   public boolean isFull() {
      // Linked list-based stacks don't have a fixed size
      // So, they are not constrained by a "full" state
      return false;
   }

   public void push(T data) {
      Node<T> nextNode = new Node<>(data);
      nextNode.next = top;
      top = nextNode;
   }

   public T pop() {
      if (isEmpty()) {
         System.out.println("UNDERFLOW");
         return null;
      }
      T data = top.data;
      top = top.next;
      return data;
   }

   public T peek() {
      if (isEmpty()) {
         System.out.println("Stack is empty. Cannot peek.");
         return null;
      }
      return top.data;
   }
}

public class StackTemplate {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter how many numbers you want to add: ");
      int size = sc.nextInt();

      Stack<Integer> stack = new Stack<>();
      System.out.println("Enter the numbers: ");
      for (int i = 0; i < size; i++) {
         int x = sc.nextInt();
         stack.push(x);
      }

      System.out.println("Peek: " + stack.peek());
      System.out.println("Pop: " + stack.pop());
      System.out.println("Pop: " + stack.pop());
      System.out.println("Peek: " + stack.peek());
      System.out.println("Pop: " + stack.pop());
      System.out.println("Pop: " + stack.pop());
      System.out.println("Peek: " + stack.peek());
      System.out.println("Pop: " + stack.pop());
      System.out.println("ARNAV SAVANT");
      System.out.println("21BCS2769");
      sc.close();
   }
}