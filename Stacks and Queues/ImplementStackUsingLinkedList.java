public class ImplementStackUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    };

    static class Stack {
        Node top;
        int size;

        Stack() {
            top = null;
            size = 0;
        }

        int getSize() {
            return size;
        }

        boolean isEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }

        void push(int data) {
            Node newNode = new Node(data);
            if (size == 0) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            size++;
        }

        void pop() {
            if (size > 0) {
                top = top.next;
                size--;
            }
        }

        int getTop() {
            if (size > 0) {
                return top.data;
            } else {
                return -1;
            }
        }
    }
}
