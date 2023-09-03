public class DoublyLinkedList {
    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteFromBeginning() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    public void deleteFromEnd() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtBeginning(0);
        list.printList();

        list.deleteFromBeginning();
        list.printList();

        list.deleteFromEnd();
        list.printList();
    }
}
