public class Leetcode_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        boolean hasCycle = false;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        slowPtr = head;
        while (slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return fastPtr;
    }
}
/*
Ah, this is a classic application of Floyd's Cycle Detection algorithm, sometimes known as the "Tortoise and the Hare" technique. Let's dissect it step by step.

### **Intuition:**
Imagine two runners, one slow (the tortoise) and one fast (the hare), running on a circular track. The fast runner will eventually catch up to the slow runner from behind. Now, if there is a small loop track attached to the main track and the runners start from the entrance of this loop track, when they meet inside the loop, the meeting point will depend on the distance between the start of the loop and their first meeting point.

To find the start of the loop (or cycle in the linked list), one of the runners can stay at the meeting point, while the other goes back to the starting line. They then start running at the same speed. When they meet again, that's the start of the loop.

### **Code Explanation:**

1. **Initialization and Edge Cases**:
   ```java
   if (head == null || head.next == null) {
       return null;
   }
   ```
   The function begins by checking if the list is empty or has only one node. In either case, a cycle is impossible, so it immediately returns null.

2. **Detecting a Cycle using Slow and Fast Pointers**:
   ```java
   ListNode slowPtr = head;
   ListNode fastPtr = head;
   while (fastPtr != null && fastPtr.next != null) {
       slowPtr = slowPtr.next;
       fastPtr = fastPtr.next.next;
       if (slowPtr == fastPtr) {
           hasCycle = true;
           break;
       }
   }
   ```
   Here, the slow pointer (`slowPtr`) moves one step at a time, while the fast pointer (`fastPtr`) moves two steps. If a cycle exists, the fast pointer will eventually catch up to the slow pointer inside the cycle. If they meet, we set the `hasCycle` flag to `true`.

3. **Finding the Start of the Cycle**:
   ```java
   if (!hasCycle) {
       return null;
   }
   slowPtr = head;
   while (slowPtr != fastPtr) {
       slowPtr = slowPtr.next;
       fastPtr = fastPtr.next;
   }
   return fastPtr;
   ```
   If no cycle was detected, the function returns null. If there's a cycle, the slow pointer is reset to the head of the linked list. Both the slow and fast pointers now move one step at a time. When they meet, that point is the start of the cycle, and it's returned.

### **Why This Works**:

1. **Detection**: The fact that the hare (fast pointer) will catch up to the tortoise (slow pointer) inside the loop, rather than skipping over it, is guaranteed by their difference in speed. If they are k steps apart, after one iteration, they will be k-1 steps apart, then k-2, and so on.

2. **Finding the Start**: The mathematics behind this is a little involved, but in essence, the distance from the head of the list to the start of the loop is the same as the distance from the first meeting point to the start of the loop, given the way the two pointers move.

This solution works in linear time, O(n), which is very efficient. It is a testament to how creative approaches can yield efficient algorithms for seemingly complex problems.
 */
