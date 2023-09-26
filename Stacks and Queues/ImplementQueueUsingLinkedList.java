class Node {
    public int data;
    public Node next;

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

class Queue {
    Node front;
    Node rear;

    void push() {
    };

    Queue() {
        front = null;
        rear = null;
    }
};

public class ImplementQueueUsingLinkedList extends Queue {
    public void push(int x) {
        Node newNode = new Node(x);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int pop() {
        if (front == null) {
            return -1;
        }
        int val = front.data;
        front = front.next;
        return val;
    }
}
