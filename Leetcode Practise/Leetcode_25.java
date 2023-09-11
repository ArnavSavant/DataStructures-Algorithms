public class Leetcode_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode();
        ListNode curr = head;
        ListNode begin = head;
        ListNode prev = null;
        boolean flag = true;
        int i = 0;
        while (curr != null) {
            if (i == k) {
                prev.next = null;
                if (flag) {
                    head = reverseList(head);
                    temp = head;
                    flag = false;
                } else {
                    temp.next = reverseList(begin);
                }
                while (temp.next != null) {
                    temp = temp.next;
                }
                prev = null;
                begin = curr;
                i = 0;
            } else {
                prev = curr;
                curr = curr.next;
                i++;
            }
        }
        if (i == k) {
            if (flag) {
                head = reverseList(head);
                flag = false;
            } else {
                temp.next = reverseList(begin);
            }
        }
        if (i != 0 && i < k) {
            temp.next = begin;
        }
        return head;
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
Alright, let's dissect the given code step by step.

The code is attempting to reverse nodes in k-group from a singly linked list. Given a linked list, the task is to reverse the nodes of the list k at a time and return its modified list. If the number of nodes is not a multiple of k then the left-out nodes in the end should remain as it is.

For instance, for a list: `1 -> 2 -> 3 -> 4 -> 5` and `k = 2`, the output should be `2 -> 1 -> 4 -> 3 -> 5`.

Let's understand the logic:

### **`reverseKGroup` Function:**
1. **Initialization**: 
   We have the following pointers and variables:
   - `temp`: Dummy node to manage the reversed groups.
   - `curr`: Pointer to traverse the linked list.
   - `begin`: Marks the beginning of a group to be reversed.
   - `prev`: Keeps track of the previous node.
   - `flag`: To identify if it's the start of the list.
   - `i`: Counter for the nodes.

2. **Traversing the List**:
   The `while` loop is used to traverse the list. Within the loop, the code checks for nodes in groups of `k`.

3. **Reversing k Nodes**:
   Once `i` reaches `k`, it means we have found k nodes which we can reverse. The linked list is then split, and the identified k nodes are reversed. If it's the start of the list (`flag` is true), the head of the list is updated. If not, the `temp` pointer (which is at the end of the last reversed group) is used to link the next reversed group.

4. **Handling the End Nodes**:
   After the loop, there's a check to handle any nodes at the end of the list if their count is equal to k (reverse them) or less than k (leave them as they are).

### **`reverseList` Function**:
This function is a standard linked list reversal function:
1. It handles the base cases where the list is empty or has only one node.
2. It uses three pointers (`temp`, `after`, `prev`) to reverse the pointers of the list iteratively.

### **Why the code works**:
- The code takes a step-wise approach. For every `k` nodes, it detaches them, reverses them, and then attaches them back to the already processed nodes.
- The use of pointers like `prev`, `begin`, and `temp` helps in managing the reversal and attachment without losing any nodes.
- The `flag` variable ensures that the head of the list is updated correctly.
- The final checks after the loop ensure that any remaining nodes (less than `k` at the end) are correctly handled.

### **Intuition**:
Think of it as being given a stack of books, and you're told to reverse every `k` books in the stack. You'd naturally count k books, reverse their order, then move to the next k, and so on. If you reach the end and don't have `k` books, you'd either reverse them if they are `k` or just place them as they are. The code essentially does the same with nodes of the linked list.
 */