public class Leetcode_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        count = count / 2;
        ListNode temp1 = head;
        ListNode temp2 = temp1.next;
        while (count-- != 0) {
            temp1.next = temp2.next;
            tail.next = temp2;
            tail = tail.next;
            temp2.next = null;

            temp1 = temp1.next;
            temp2 = temp1.next;
        }
        return head;
    }
}
/*
 The given code is aiming to solve a common linked list problem - rearranging the linked list such that all odd nodes appear first, followed by the even nodes, while maintaining the relative order of the odd and even nodes.

Before delving into the code, let's get an intuition:

**Intuition**: 

Imagine you're given a row of people standing, and you're asked to rearrange them such that every person wearing a blue shirt (analogous to the odd node) stands first, followed by every person wearing a green shirt (analogous to the even node), but they must maintain their original relative standing positions. A simple way to achieve this is by pulling out every person wearing a green shirt and moving them to the end of the row, one-by-one, until you've moved half of the total number of people.

Now, let's understand the code in detail:

1. **Base Cases**:
   ```java
   if (head == null || head.next == null || head.next.next == null) {
       return head;
   }
   ```
   If the list is empty, has only one node, or just two nodes, it's already in the required format, and we return it directly.

2. **Finding the tail and the length**:
   ```java
   ListNode tail = head;
   int count = 1;
   while (tail.next != null) {
       tail = tail.next;
       count++;
   }
   ```
   We traverse the list to find the tail and also count the number of nodes. We'll need to know when to stop rearranging, which will be after we've processed half of the list.

3. **Rearranging**:
   ```java
   count = count / 2;
   ListNode temp1 = head;
   ListNode temp2 = temp1.next;
   while (count-- != 0) {
       temp1.next = temp2.next;
       tail.next = temp2;
       tail = tail.next;
       temp2.next = null;

       temp1 = temp1.next;
       temp2 = temp1.next;
   }
   ```
   - We start with two pointers `temp1` and `temp2`. `temp1` always points to the last processed odd node, and `temp2` points to the last processed even node.
   - In every iteration, we're doing the following:
     - Skip the node at `temp1` (as it's an odd node and should remain in its place).
     - Move the node at `temp2` (an even node) to the end.
     - Update our pointers to point to the next odd and even nodes, respectively.

This loop runs for `count/2` times, ensuring we've moved half of the list's nodes, thereby rearranging all even nodes after all odd nodes.

To visualize the process, let's say our list is: `1 -> 2 -> 3 -> 4 -> 5`. The goal is to get `1 -> 3 -> 5 -> 2 -> 4`.

The algorithm does this by iterating through the list, taking each even node (`2`, then `4`), and moving it to the end, updating pointers as it goes along.

**In conclusion**, this method provides an intuitive way of segregating odd and even nodes in a linked list. The iteration and rearrangement make it evident how we're keeping the relative order of the nodes intact while achieving the desired configuration.
 */