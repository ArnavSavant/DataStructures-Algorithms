public class Leetcode_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        slowPtr.next = reverseList(slowPtr.next);
        slowPtr = slowPtr.next;
        fastPtr = slowPtr;
        slowPtr = head;
        while (fastPtr != null) {
            if (slowPtr.val != fastPtr.val) {
                return false;
            }
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode after = temp.next;
        ListNode prev = null;
        while (after != null) {
            temp.next = prev;
            prev = temp;
            temp = after;
            after = temp.next;
        }
        temp.next = prev;
        return temp;
    }
}

/*
Alright, as the esteemed professor of the Institute of Data Structures and Algorithms, let's dive deep into understanding this piece of code, step by step.

**Problem Statement**: Check if a given linked list is a palindrome.

**Intuition**: 
A palindrome is a sequence of characters that reads the same forward and backward (like "radar" or "level"). If we reverse the second half of the sequence and it becomes the same as the first half, then it's a palindrome.

The key idea behind this solution is:
1. Find the middle of the linked list.
2. Reverse the second half of the linked list.
3. Compare the first half and the reversed second half.
4. If they are the same, then it's a palindrome.

**Breaking Down the Code**:

1. **Finding the Middle**:
   ```java
   ListNode slowPtr = head;
   ListNode fastPtr = head;
   while (fastPtr.next != null && fastPtr.next.next != null) {
       slowPtr = slowPtr.next;
       fastPtr = fastPtr.next.next;
   }
   ```
   We use the tortoise and hare (slow and fast pointer) approach. The slow pointer moves one step at a time while the fast pointer moves two steps. By the time the fast pointer reaches the end of the list, the slow pointer will be at the middle of the list.

2. **Reversing the Second Half**:
   ```java
   slowPtr.next = reverseList(slowPtr.next);
   ```
   We call the `reverseList` function on the next node of the middle node. This is because we want the middle node to act as the end of the first half (especially in the case of an odd length linked list).

3. **Comparing Both Halves**:
   ```java
   slowPtr = slowPtr.next;
   fastPtr = slowPtr;
   slowPtr = head;
   while (fastPtr != null) {
       if (slowPtr.val != fastPtr.val) {
           return false;
       }
       slowPtr=slowPtr.next;
       fastPtr=fastPtr.next;
   }
   ```
   We use two pointers again. `slowPtr` starts at the beginning of the list (i.e., `head`), and `fastPtr` starts at the beginning of the reversed second half. We then iterate through both the first half and the reversed second half, comparing values. If any values are different, it's not a palindrome.

4. **Reversing the Linked List**:
   The function `reverseList` reverses the given linked list and returns the new head. This involves reassigning the `next` pointer of every node to its previous node.

**Why This Works**:
Reversing the second half of the list and then comparing it with the first half ensures we are checking for palindrome properties. If the two halves are the same (given that the second half is reversed), it means the list is a palindrome.

**Time Complexity**: 
Both finding the middle and reversing the second half take O(n/2) which is O(n). The comparison also takes O(n/2) which is O(n). Thus, the total time complexity is O(n). 

**Space Complexity**: 
Since we are reversing the linked list in-place and are using a constant amount of space, the space complexity is O(1).
 */
