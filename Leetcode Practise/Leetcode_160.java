public class Leetcode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = getLength(headA);
        int l2 = getLength(headB);
        if (l1 <= l2) {
            return getNode(headB, headA, l2, l1);
        } else {
            return getNode(headA, headB, l1, l2);
        }
    }

    private ListNode getNode(ListNode headA, ListNode headB, int l1, int l2) {
        int diff = l1 - l2;
        ListNode tempA = headA;
        while (diff-- != 0) {
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempA != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}
/*
Alright, let's dive deep into this code. This code is designed to find the intersection node of two linked lists, if it exists.

**Intuition**:
Imagine two runners on a racetrack with different starting points on the track. If one runner starts further ahead than the other, we can let that runner stand still until the other one reaches a point where they both have the same distance to the finish line. Now, if they start running at the same speed, and there's a meeting point, they will meet exactly at that point. 

This code uses a similar intuition but with linked lists.

### **Understanding the Code**:

1. **getLength(ListNode head)**:
   - A helper function to compute the length of a linked list.
   - It simply traverses the list from start to end while counting the nodes.

2. **getIntersectionNode(ListNode headA, ListNode headB)**:
   - Here, the lengths of both linked lists are calculated.
   - Then, it determines which linked list is longer and then delegates the task of finding the intersection to the `getNode` function. The longer list is passed first.

3. **getNode(ListNode headA, ListNode headB, int l1, int l2)**:
   - The core logic of our solution.
   - It first computes the difference in lengths (`diff = l1 - l2`).
   - It advances the pointer of the longer list (`tempA`) by the difference in lengths. This is akin to the earlier mentioned analogy of letting one runner stand still until the other one reaches a comparable starting point.
   - Now, both pointers `tempA` and `tempB` are equidistant from the end of the linked lists (or the potential intersection point).
   - The code then traverses both lists simultaneously, checking if `tempA` and `tempB` point to the same node (i.e., they've intersected).
   - If they meet (intersect), the intersection node is returned.

**Why does this work?**

By ensuring that both pointers have the same number of nodes ahead of them, we can guarantee that if they intersect, they will do so at the same node. They traverse their remaining nodes in tandem, making them bound to meet at the intersection point if one exists.

To reiterate, this is analogous to our running track analogy. Once both runners have the same distance to the finish line, they will meet at the intersection point if there is one.

**Time Complexity**:
The solution traverses each linked list at most twice (once for length and once for comparison). Therefore, the time complexity is O(n + m) where n and m are the lengths of the two linked lists, respectively. This is linear time complexity.
 */
