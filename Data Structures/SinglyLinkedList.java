public class SinglyLinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteFromBeginning() {
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
    }

    public void deleteFromEnd() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }
        tail = currentNode;
        tail.next = null;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
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
