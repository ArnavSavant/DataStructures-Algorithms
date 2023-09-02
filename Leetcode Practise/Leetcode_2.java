public class Leetcode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansHead = null;
        ListNode ansTail = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);

            if (ansHead == null) {
                ansHead = temp;
                ansTail = temp;
            } else {
                ansTail.next = temp;
                ansTail = ansTail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);

            if (ansHead == null) {
                ansHead = temp;
                ansTail = temp;
            } else {
                ansTail.next = temp;
                ansTail = ansTail.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);

            if (ansHead == null) {
                ansHead = temp;
                ansTail = temp;
            } else {
                ansTail.next = temp;
                ansTail = ansTail.next;
            }
            l2 = l2.next;
        }

        if (carry > 0) {
            ListNode temp = new ListNode(carry);

            if (ansHead == null) {
                ansHead = temp;
                ansTail = temp;
            } else {
                ansTail.next = temp;
                ansTail = ansTail.next;
            }
        }
        return ansHead;
    }
}
/*
Alright, let's dive into this code. At a high level, this function is aiming to simulate the manual process of adding two numbers. Instead of using two integer numbers, the numbers are represented as linked lists, where each node in the list represents a digit, and the order of the nodes in the list is the reverse order of the digits.

**Example**: The number `143` would be represented as the list `3 -> 4 -> 1`.

Now, let's go step-by-step through the code:

1. **Initialization**:
```java
ListNode ansHead = null;
ListNode ansTail = null;
int carry = 0;
```
Here, we are initializing the head and tail of the answer linked list (`ansHead` and `ansTail`). The `carry` variable will be used to keep track of any carried-over value during addition.

2. **Adding nodes from both lists (while both are not null)**:
```java
while (l1 != null && l2 != null) {
    int sum = l1.val + l2.val + carry;
    ...
}
```
As long as both `l1` and `l2` are not null, we keep adding their respective values (along with any carry from the previous step).

3. **Handling Remaining Nodes of List `l1`**:
```java
while (l1 != null) {
    int sum = l1.val + carry;
    ...
}
```
If `l1` is longer than `l2`, we need to keep adding the remaining nodes of `l1` to our answer list. We still consider any carried-over value.

4. **Handling Remaining Nodes of List `l2`**:
```java
while (l2 != null) {
    int sum = l2.val + carry;
    ...
}
```
Similarly, if `l2` is longer than `l1`, we keep adding the remaining nodes of `l2` to our answer list.

5. **Handling left-over carry**:
```java
if (carry > 0) {
    ListNode temp = new ListNode(carry);
    ...
}
```
After traversing both lists, there might still be a carry left. If there is, we add it as a new node.

---

**Intuition and Logic**:

The code is mimicking the way we manually add two numbers:
- Start from the least significant digit (rightmost) of both numbers.
- Add the digits together, and if the sum is 10 or greater, carry over.
- Move to the next digit and repeat.

In this linked list representation, the head of the list represents the least significant digit, so we start there. And as we add digits together, we construct the answer list node by node.

The reason for the three separate while loops is to handle numbers (lists) of different lengths. For example, adding `349` (represented as `9 -> 4 -> 3`) and `75` (represented as `5 -> 7`) requires you to handle the last digit of the longer number (`349` in this case) separately.

In the end, if there's any leftover carry (for instance, when adding `999` and `1`), it's handled and added as the most significant digit of the result.

**Efficiency**:
The time complexity is \(O(\max(n, m)\), where \(n\) and \(m\) are the lengths of `l1` and `l2` respectively. This is because we traverse each list at most once. The space complexity is also \(O(\max(n, m)\) or \(O(\max(n, m) + 1)\) in the case where an additional carry node is needed (like in `999 + 1`).
 */
