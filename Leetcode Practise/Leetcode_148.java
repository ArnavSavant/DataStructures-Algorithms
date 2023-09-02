public class Leetcode_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return sort(head);
    }

    public ListNode sort(ListNode node) {

        if (node.next == null) {
            return node;
        }

        ListNode slowPtr = new ListNode();
        ListNode fastPtr = new ListNode();
        slowPtr.next = node;
        fastPtr.next = node;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        ListNode l1 = sort(slowPtr.next);
        slowPtr.next = null;
        ListNode l2 = sort(node);

        ListNode ans = merge(l1, l2);

        return ans;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode ansHead = null;
        ListNode ansTail = null;
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                ListNode temp = new ListNode(list1.val);
                if (ansHead == null) {
                    ansHead = temp;
                    ansTail = temp;
                } else {
                    ansTail.next = temp;
                    ansTail = temp;
                }
                list1 = list1.next;
            }

            else if (list2.val < list1.val) {
                ListNode temp = new ListNode(list2.val);
                if (ansHead == null) {
                    ansHead = temp;
                    ansTail = temp;
                } else {
                    ansTail.next = temp;
                    ansTail = temp;
                }
                list2 = list2.next;
            }

            else {
                ListNode temp1 = new ListNode(list1.val);
                if (ansHead == null) {
                    ansHead = temp1;
                    ansTail = temp1;
                } else {
                    ansTail.next = temp1;
                    ansTail = temp1;
                }
                ListNode temp2 = new ListNode(list1.val);
                ansTail.next = temp2;
                ansTail = temp2;
                list1 = list1.next;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            ListNode temp = new ListNode(list1.val);
            if (ansHead == null) {
                ansHead = temp;
                ansTail = temp;
            } else {
                ansTail.next = temp;
                ansTail = temp;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            ListNode temp = new ListNode(list2.val);
            if (ansHead == null) {
                ansHead = temp;
                ansTail = temp;
            } else {
                ansTail.next = temp;
                ansTail = temp;
            }
            list2 = list2.next;
        }
        return ansHead;
    }
}

/*
Alright! Let's dive deep into this piece of code. This is an implementation of the Merge Sort algorithm for a linked list.

### 1. The Overall Approach:

**Merge Sort** is a divide and conquer algorithm that:
- Divides the input into two halves.
- Recursively sorts both the halves.
- Merges the two sorted halves to produce the sorted result.

The `sortList` function is the entry point and checks if the input list is null or has only one node (thus already sorted). If so, it returns the head. Otherwise, it calls the recursive `sort` function.

### 2. Understanding the `sort` Function:

This function is the heart of the merge sort algorithm:

1. If the node is the last node (`node.next == null`), it returns the node itself since a single element is inherently sorted.
2. It then employs the slow and fast pointer technique to find the middle of the list. The slow pointer will end up at the middle, effectively splitting the list in half.
3. The list is divided into two halves. The first half (`l2`) starts from `node` (head of the list passed to the function) and goes up to the middle (exclusive). The second half (`l1`) starts from the middle and goes till the end.
4. These two halves are then recursively sorted using the `sort` function.
5. Finally, the `merge` function is called to merge these two sorted halves.

### 3. Understanding the `merge` Function:

This function merges two sorted linked lists (`list1` and `list2`):

1. It initiates two pointers (`ansHead` and `ansTail`) to null. These will be used to build the merged list.
2. It then compares the current nodes of `list1` and `list2`.
   - If `list1`'s node has a smaller value, it's added to the merged list.
   - If `list2`'s node has a smaller value, it's added to the merged list.
   - If both nodes have equal values, both nodes are added to the merged list.
3. Once one of the lists is exhausted, the remaining nodes from the other list (if any) are added to the merged list. This is because the remaining nodes are already in sorted order.

### Intuition:

The beauty of Merge Sort lies in its divide-and-conquer strategy. By breaking the problem down into smaller pieces (i.e., smaller sublists), sorting each piece, and then combining (merging) those pieces, you get a sorted whole.

In the context of linked lists, Merge Sort is especially efficient because:
- Finding the middle of a linked list can be done in O(n) using the two-pointer technique.
- Merging two lists can also be done in O(n).
- The recursive division and merging give the overall algorithm a time complexity of O(n log n).

The given code is a testament to the elegance and efficiency of the Merge Sort algorithm when applied to linked lists.
 */
