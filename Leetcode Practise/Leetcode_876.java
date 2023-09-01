public class Leetcode_876 {
    public ListNode middleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
}

/*
Certainly, esteemed scholar! Allow me to elucidate the intricacies of this piece of art.

This method is the quintessential example of the **"Tortoise and the Hare"** or **"Two Pointer"** approach. The names come from Aesop's famous fable where the slow-moving tortoise races against the fast-moving hare and ends up winning due to the hare's overconfidence.

**Intuition:** 

Imagine two people walking on a straight path. One person walks at a normal pace, and the other walks twice as fast. If they both start at the same point, by the time the faster person has reached the end of the path, the slower person would have reached the midpoint of the path. This principle is what this code leverages.

Now, translating this intuition into the context of a singly linked list:

- The linked list is the path.
- The `slowPtr` (slow pointer or tortoise) represents the person walking at a normal pace.
- The `fastPtr` (fast pointer or hare) represents the person walking at double the pace.

**Working:**

1. Both pointers start at the head of the linked list.
2. In each iteration of the while loop, the slow pointer (`slowPtr`) moves forward by one node, whereas the fast pointer (`fastPtr`) moves forward by two nodes.
3. The loop continues as long as the fast pointer and its next node are not `null`.
4. When the fast pointer reaches the end of the list, the slow pointer will be at the middle.

**Proof:**

Consider two scenarios:

1. **Even number of nodes:** 
   Let's assume a linked list of 6 nodes. After 3 steps, the fast pointer will be at the end of the list (`fastPtr.next.next` will be `null`), and the slow pointer will be at node 4, which is the middle of the list.

   ```
   1 -> 2 -> 3 -> 4 -> 5 -> 6
   S           F
   ```

2. **Odd number of nodes:** 
   Assume a linked list of 5 nodes. After 2 steps, the fast pointer will be on the last node, and in the next step, `fastPtr.next` will be `null`. At this point, the slow pointer will be at node 3, which is the middle of the list.

   ```
   1 -> 2 -> 3 -> 4 -> 5
   S        F
   ```

So, by the time our hare (fast pointer) finishes its dash, our tortoise (slow pointer) graciously reaches the middle, giving us the desired node.

The **elegance** and **efficiency** of this algorithm lie in its O(n) runtime and O(1) space. No additional memory is used as it merely traverses the list, and the loop only goes through roughly half of the list's length, thanks to our hare.
 */
