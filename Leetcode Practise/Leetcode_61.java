public class Leetcode_61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 1;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            n++;
        }

        int x = k % n;
        if (x == 0) {
            return head;
        }
        int remainder = n - x;

        ListNode temp = head;
        for (int i = 1; i < remainder; i++) {
            temp = temp.next;
        }
        end.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}

/*
Absolutely! This is a classic LinkedList problem. The code rotates a singly linked list to the right by `k` places. Let's dissect it.

**Understanding The Problem:**
Given a linked list `1->2->3->4->5` and `k = 2`, the list should be rotated to `4->5->1->2->3`.

**Intuition:**
Notice that if you were to rotate the linked list `n` times (where `n` is the length of the linked list), the list would look exactly the same as the original list. So, rotating `k` times is equivalent to rotating `k % n` times. The algorithm capitalizes on this observation.

**Code Explanation:**

1. **Edge Cases**:
    ```java
    if (head == null || head.next == null || k == 0) {
        return head;
    }
    ```
    - If the list is empty, has only one node, or if `k` is zero, return the head. No rotation is needed.

2. **Find List Length and Last Node**:
    ```java
    int n = 1;
    ListNode end = head;
    while (end.next != null) {
        end = end.next;
        n++;
    }
    ```
    - `end` will point to the last node in the list after this loop.
    - `n` will have the total number of nodes in the list.

3. **Calculate Effective Rotations**:
    ```java
    int x = k % n;
    ```
    - This gives the effective number of rotations we need. This is based on our earlier observation that rotating `n` times (or multiples of `n` times) returns the list to its original form.

4. **Edge Case**:
    ```java
    if (x == 0) {
        return head;
    }
    ```
    - If `x` is zero, no rotation is needed. Return the original head.

5. **Find New Head of Rotated List**:
    ```java
    int remainder = n - x;

    ListNode temp = head;
    for (int i = 1; i < remainder; i++) {
        temp = temp.next;
    }
    ```
    - The node at the position `remainder` will be the last node before the rotation point. 
    - `temp` will point to this node after the loop.

6. **Perform Rotation**:
    ```java
    end.next = head; 
    head = temp.next; 
    temp.next = null;
    ```
    - `end.next = head;` connects the last node of the list to the current head, making a cycle.
    - `head = temp.next;` updates the head to start from the node after `temp`.
    - `temp.next = null;` breaks the cycle to make it a standard singly linked list again.

7. **Return the new head**:
    ```java
    return head;
    ```

**Visual Walkthrough:**
Let's use an example. Assume we have the list `1->2->3->4->5` and `k = 7`. 
- After calculating, `x = 7 % 5 = 2`. This means we need to rotate 2 places to the right.
- Our target is to move the node just before the 3rd last node (`3` in this case). 
- After connecting the end to the head and updating the pointers, we get our rotated list `4->5->1->2->3`.

Thus, the provided code uses two-pointer logic and modular arithmetic to efficiently rotate a linked list to the right by `k` positions.
 */