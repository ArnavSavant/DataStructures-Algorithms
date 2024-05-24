public class Leetcode_2816 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        int carry = 0;
        ListNode temp = head;
        while (temp != null) {
            int val = temp.val;
            val = val * 2 + carry;
            carry = 0;
            if (val > 9) {
                carry = val / 10;
                val = val % 10;
            }
            temp.val = val;
            temp = temp.next;
        }
        head = reverseList(head);
        if (carry > 0) {
            temp = new ListNode(carry);
            temp.next = head;
            head = temp;
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
