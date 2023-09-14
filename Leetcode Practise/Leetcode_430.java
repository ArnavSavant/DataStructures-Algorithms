public class Leetcode_430 {
    private class Node {
        private int val;
        private Node prev;
        private Node next;
        private Node child;
    };

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        if(head.prev == null) {
            System.out.println(head.val);
        }
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node nextNode = curr.next;
                Node temp = flatten(curr.child);
                curr.child = null;
                curr.next = temp;
                temp.prev = curr;
                while (temp.next != null) {
                    temp = temp.next;
                }
                if (nextNode == null) {
                    break;
                }
                temp.next = nextNode;
                nextNode.prev = temp;
                curr = nextNode;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
/*
 * To understand the function and the logic behind it, let's break it down step
 * by step. This function aims to flatten a doubly linked list where in addition
 * to the usual next and prev pointers, a node can have a child pointer, which
 * may or may not point to a separate doubly linked list. These child lists may
 * have one or more nodes and might even have children of their own.
 ** 
 * Basic structure of the function:**
 * 
 * 1. Check if the given `head` node is null, if yes, return it.
 * 2. Use a `curr` pointer to traverse through the linked list.
 * 3. If the current node has a child, flatten that child's list, and then merge
 * it with the main list.
 * 4. If the current node does not have a child, move to the next node.
 * 5. Return the head of the flattened linked list.
 ** 
 * Breaking down the logic of the code:**
 * 
 * 1. **Base Case:**
 * ```java
 * if (head == null) {
 * return head;
 * }
 * ```
 * If the `head` node is null, it means the list is empty. So, simply return
 * null.
 * 
 * 2. **Loop to Traverse the List:**
 * ```java
 * Node curr = head;
 * while (curr != null) {
 * ...
 * curr = curr.next;
 * }
 * ```
 * `curr` is initialized to `head`, and it will be used to traverse the list. As
 * long as `curr` is not null, the loop will continue.
 * 
 * 3. **Checking for Child Node and Flattening:**
 * ```java
 * if (curr.child != null) {
 * ...
 * }
 * ```
 * If the current node has a child, the function enters the if block to handle
 * the child list.
 * 
 * 4. **Flatten the Child List:**
 * ```java
 * Node temp = flatten(curr.child);
 * ```
 * Recursively call the `flatten` function on the child list. This will ensure
 * that if the child list has any other child lists of its own, they will be
 * flattened as well.
 * 
 * 5. **Merging the Flattened Child List with the Main List:**
 * ```java
 * curr.child = null;
 * curr.next = temp;
 * temp.prev = curr;
 * ```
 * Set the `child` pointer of `curr` to null since the child list is now
 * flattened and merged. Adjust the next and previous pointers of `curr` and the
 * head of the child list (`temp`) to merge the two lists.
 * 
 * 6. **Connect the Tail of the Flattened Child List with the Rest of the Main
 * List:**
 * ```java
 * while (temp.next != null) {
 * temp = temp.next;
 * }
 * if (nextNode == null) {
 * break;
 * }
 * temp.next = nextNode;
 * nextNode.prev = temp;
 * ```
 * After merging the child list with the main list, the next step is to connect
 * the tail of the flattened child list with the remaining part of the main
 * list. For this, traverse to the end of the child list using the `temp`
 * pointer. Then, connect the tail of the child list (`temp`) with `nextNode`
 * which is the node after `curr` in the main list.
 * 
 * 7. **Return the head:**
 * ```java
 * return head;
 * ```
 * Finally, after flattening and merging, the function returns the head of the
 * flattened linked list.
 ** 
 * Intuition:**
 * This function works because of its recursive nature. The flatten function is
 * recursively called for each child list encountered, ensuring all child lists
 * are flattened and merged with the main list. The process of merging is done
 * by adjusting the next and prev pointers. The code is designed to handle
 * nested child lists, making sure they are all flattened into a single, unified
 * doubly linked list.
 */
