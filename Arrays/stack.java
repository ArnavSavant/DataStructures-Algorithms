public class stack {
    int stack1[];
    int top;

    stack(int size) {
        stack1 = new int[size];
        top = -1;
    }

    public void push(int val) {
        if (top == (stack1.length - 1)) {
            System.out.println("Overflow");
            return;
        } else {
            top++;
            stack1[top] = val;
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Overlow");
        } else {
            System.out.println("Popped Element: " + stack1[top--]);
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == (stack1.length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public void top() {
        if (top == -1) {
            System.out.println("Overlow");
        } else {
            System.out.println("Element at top: " + stack1[top]);
        }
        System.out.println("");
    }

    public void reverse() {
        int stack2[] = new int[stack1.length];
        int top2 = -1;
        while (top != -1) {
            stack2[++top2] = stack1[top--];
        }
        System.out.print("Stack in reverse order: ");
        while (top2 != -1) {
            System.out.print(stack2[top2--] + " ");
        }
    }

    public void printStack() {
        System.out.print("Stack: ");
        int temp = top;
        while (temp != -1) {
            System.out.print(stack1[temp--] + " ");
        }
        System.out.println("");
        System.out.println("");
    }

    public static void main(String[] args) {
        stack s1 = new stack(5);
        System.out.println("Size of stack: " + s1.stack1.length);
        System.out.println("");
        System.out.println("Is stack Empty ? " + s1.isEmpty());
        s1.printStack();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println("Is stack Full ? " + s1.isFull());
        s1.printStack();
        s1.push(40);
        s1.push(50);
        System.out.println("Is stack Full ? " + s1.isFull());
        s1.printStack();
        System.out.println("Before Popping");
        s1.printStack();
        s1.pop();
        System.out.println("After Popping");
        s1.printStack();
        s1.top();
        s1.reverse();
    }
}
