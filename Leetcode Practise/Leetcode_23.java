import java.util.PriorityQueue;

public class Leetcode_23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    
    public class Pair implements Comparable<Pair> {
        int listIndex;
        int val;

        Pair(int li, int val) {
            this.listIndex = li;
            this.val = val;
        }

        public int compareTo(Pair o) {
            if (this.val == o.val) {
                return Integer.compare(this.listIndex, o.listIndex);
            }
            return Integer.compare(this.val, o.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ansHead = null;
        ListNode ansTail = null;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(new Pair(i, lists[i].val));
                lists[i] = lists[i].next;
            }
        }
        while (minHeap.size() > 0) {
            Pair p = minHeap.remove();
            ListNode newNode = new ListNode(p.val);
            if (ansHead == null) {
                ansHead = newNode;
                ansTail = newNode;
            } else {
                ansTail.next = newNode;
                ansTail = newNode;
            }
            if (lists[p.listIndex] != null) {
                p.val = lists[p.listIndex].val;
                lists[p.listIndex] = lists[p.listIndex].next;
                minHeap.add(p);
            }
        }
        return ansHead;
    }
}
/*
Overview:
This code implements the merging of k sorted linked lists using a min-heap (PriorityQueue). The ListNode class represents a node in a linked list, and the Pair class is used to store a pair of values (listIndex and val) for each node. The mergeKLists method takes an array of sorted linked lists as input and merges them into a single sorted linked list.

Logic and Intuition:
Initialization:

ansHead and ansTail are initially set to null, representing the head and tail of the merged linked list.
PriorityQueue<Pair> minHeap is used to keep track of the minimum element from all the lists. It is ordered based on the values of the nodes.
Populating the Heap:

The code iterates through the given array of linked lists (lists).
For each linked list, if it's not empty, create a Pair with the list index (i) and the value of the first node in the list. Add this pair to the minHeap and move the pointer of the corresponding list to the next node.
Merging:

The main logic involves repeatedly selecting the minimum element from the heap and updating the heap with the next element from the same list.
A new node (newNode) is created with the value p.val.
If the merged list is empty (ansHead == null), ansHead is set to newNode, and ansTail is updated accordingly. Otherwise, the new node is appended to the merged list.
If there are more nodes in the same list (lists[p.listIndex]), the value of p is updated with the value of the next node from that list, and p is added back to the heap.
Final Result:

The merged linked list is represented by ansHead, and it is returned as the final result.
Time Complexity:
Let n be the total number of nodes across all linked lists.
Each node is added to and removed from the heap once, which takes O(log k) time, where k is the number of lists.
The overall time complexity is O(n log k), where n is the total number of nodes.
Space Complexity:
The space complexity is O(k) due to the priority queue (minHeap) storing at most k elements.
The additional space required for creating new nodes and variables is O(1).
The overall space complexity is O(k).
Summary:
The code efficiently merges k sorted linked lists using a min-heap, ensuring that the merged list is constructed in sorted order. The time complexity is O(n log k), where n is the total number of nodes, and the space complexity is O(k). The use of a priority queue allows for selecting the minimum element efficiently during the merging process.
 */