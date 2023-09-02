public class Leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) {
            return null;
        }
        ListNode temp = head;
        while (n-- != 0) {
            temp = temp.next;
        }
        if(temp==null) {
            return head.next;
        }
        ListNode start = head;
        while (temp.next != null) {
            start = start.next;
            temp = temp.next;
        }
        start.next = start.next.next;
        return head;
    }
}
/*
Certainly! Let's go step by step through this elegant piece of code that addresses the problem of removing the \(n^{th}\) node from the end of a linked list.

### **Problem Statement**:
Given a linked list, remove the \(n^{th}\) node from the end of the list and return its head.

### **Code Breakdown and Intuition**:

1. **Base Check**:
   ```java
   if(head==null) {
       return null;
   }
   ```
   If the head is `null`, then the list is empty. In this case, there's nothing to remove, so the function returns `null`.

2. **Moving the `temp` pointer**:
   ```java
   ListNode temp = head;
   while (n-- != 0) {
       temp = temp.next;
   }
   ```
   This part of the code moves the `temp` pointer `n` nodes ahead. Think of this as giving one pointer a head start in a race.

3. **Checking if `temp` is null**:
   ```java
   if(temp==null) {
       return head.next;
   }
   ```
   If after moving `n` nodes, `temp` is `null`, it means the node to be deleted is the head of the list. Thus, we skip the head by returning `head.next`.

4. **Moving `start` and `temp` pointers simultaneously**:
   ```java
   ListNode start = head;
   while (temp.next != null) {
       start = start.next;
       temp = temp.next;
   }
   ```
   Here, `start` begins at the head of the list, and both `temp` and `start` move together one step at a time. By the time `temp` reaches the end of the list, `start` will be just before the node to be removed (since `temp` was given a head start of `n` nodes).

5. **Removing the \(n^{th}\) node from the end**:
   ```java
   start.next = start.next.next;
   ```
   `start` is now at the node just before the one we want to remove. This line simply skips over the next node, effectively removing it from the list.

6. **Returning the potentially new head**:
   ```java
   return head;
   ```
   Finally, the modified list's head is returned.

### **Conceptual Understanding**:
Imagine you and a friend are standing on a straight track. You ask your friend to start walking, and once they're `n` steps ahead, you start walking too. When your friend reaches the end, you'll be `n` steps behind them. This is the intuition behind the "two pointers with a gap" method used in this solution. By giving one pointer a head start, and then moving both pointers until the lead pointer reaches the end, the trailing pointer will naturally land on the `n`-th node from the end.

### **Conclusion**:
This technique, by using a gap of `n` nodes between two pointers, allows us to identify and remove the `n`-th node from the end of a list in a single pass, making it a very efficient solution.
 */
