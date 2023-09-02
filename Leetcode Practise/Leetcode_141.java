public class Leetcode_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }
}

/*
Certainly! This code is a classic implementation of Floyd's Cycle-Finding Algorithm, often referred to as the "tortoise and the hare" algorithm.

**Purpose:**  
The purpose of this algorithm is to determine if a linked list has a cycle.

**Basic Intuition:**  
Imagine two runners on a circular track. One runner (the hare) is much faster than the other (the tortoise). If they both start at the same starting point and the track is circular (has a loop), they are bound to meet again at some point.

**Code Explanation:**

1. **Base Condition:**
```java
if (head == null || head.next == null) {
    return false;
}
```
This checks if the list is empty or has only one element. In both cases, a cycle isn't possible.

2. **Initialization:**
```java
ListNode slowPtr = head;
ListNode fastPtr = head;
```
We initialize two pointers: `slowPtr` (tortoise) and `fastPtr` (hare), both starting at the head of the linked list.

3. **Traversal:**
```java
while (fastPtr != null && fastPtr.next != null) {
    slowPtr = slowPtr.next;
    fastPtr = fastPtr.next.next;
    ...
}
```
Here's where the main logic happens. The slow pointer (tortoise) moves one step at a time, while the fast pointer (hare) moves two steps. 

Why? If there's a loop, the fast pointer will eventually catch up to the slow pointer inside the loop, just like a faster runner on a circular track will eventually catch up to a slower runner.

4. **Cycle Detection:**
```java
if (slowPtr == fastPtr) {
    return true;
}
```
If at any point during the traversal, the slow pointer and fast pointer meet (point to the same node), then there's a loop in the linked list.

5. **End of Traversal:**
If the `while` loop completes without the two pointers meeting, it means the fast pointer has reached the end of the list and there's no loop. The function will then return `false`.

**Why it Works:**  
If there's no cycle, the fast pointer (which moves two steps at a time) will simply hit the end of the list. However, if there's a cycle, the fast pointer will eventually enter the cycle and will catch up to the slow pointer, which is also moving through the cycle but at half the speed.

Imagine a circular track. No matter where the two runners start within the loop, the faster one will eventually catch up to the slower one. The same logic applies here.

**Time Complexity:**  
The algorithm runs in O(n) time, where n is the number of nodes in the linked list. Even though there are two pointers moving through the list, the faster pointer ensures that the loop will exit as soon as a cycle is detected or the end of the list is reached.
 */
