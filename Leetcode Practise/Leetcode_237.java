public class Leetcode_237 {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        while (temp.next != null) {
            node.val = temp.val;
            node = node.next;
            temp = temp.next;
        }
        node.val = temp.val;
        node.next = null;
    }
}

/*
Alright, esteemed learner! Let's dissect this ingenious little piece of code. At a glance, it's a method designed to delete a node from a singly linked list. But the peculiar part is that it's not given the head of the list, only the node it's supposed to delete. This is a bit like being asked to leave a locked room without touching the door – you have to think outside the box!

### The Problem:

Normally, to delete a node from a linked list, you'd traverse from the head until you find the node prior to the one you want to delete, and then adjust the 'next' pointer of that previous node to skip over the node to be deleted.

However, the challenge here is that you don't have access to the head of the linked list. You only have access to the node you need to delete, which means you can't traverse from the beginning of the list to reach the node before it.

### The Intuition:

Since we can't go backwards in a singly linked list, we have to re-think our approach. What if, instead of deleting the given node, we overwrite its value with the next node's value, and then delete the next node? This would effectively achieve the same end result, with the original node's value being gone and the list structure remaining intact.

### Logic Explained:

1. **Initialization**: We begin by creating a temporary pointer `temp` which points to the node after the current `node`.

   ```java
   ListNode temp = node.next;
   ```

2. **Overwriting Loop**: Now, we iterate through the list, starting from `node` and `temp`, and at each step:
   - Copy the value of `temp` (the next node) into the current `node`.
   - Move both `node` and `temp` one step ahead.
   
   This process essentially shifts all the values of the nodes from our target node to the end of the list one step backwards.

   ```java
   while(temp.next!=null) {
       node.val = temp.val;
       node = node.next;
       temp = temp.next;
   }
   ```

3. **Final Deletion**: By the time the loop exits, `node` points to the second-last node in the sequence, and `temp` points to the last node. We then copy the last value to `node` and set `node.next` to `null`, effectively removing the last node from the list.

   ```java
   node.val = temp.val;
   node.next = null;
   ```

### An Example:

Consider a linked list: `1 -> 2 -> 3 -> 4 -> 5`, and let's say we want to delete the node with value `3`.

The algorithm would work as follows:
- Overwrite `3` with `4`: `1 -> 2 -> 4 -> 4 -> 5`
- Move to next node and overwrite `4` with `5`: `1 -> 2 -> 4 -> 5 -> 5`
- Delete the last node: `1 -> 2 -> 4 -> 5`

Thus, the node with the value `3` has been effectively "deleted", by being overwritten by subsequent values and the final duplicate node being removed.

### Why This Works:

The cleverness of this method lies in sidestepping the need to know the previous node. By shifting values from subsequent nodes and then trimming the list at the end, we simulate the deletion of the given node without ever needing to touch any node before it in the list.

### Note:

This method has a limitation: it cannot delete the last node of the list since there's no "next node" to copy from. In the context where this method is used, it's typically assumed that the given node will not be the last one in the list.
 */
