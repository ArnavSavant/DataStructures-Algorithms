import java.util.HashMap;
import java.util.Map;

public class Leetcode_1171 {
    static class ListNode {
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

    public ListNode removeZeroSumSublists(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int arr[] = new int[n];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for (i = 0; i < n; i++) {
            int x = arr[i];
            if (x == 0) {
                arr[i] = Integer.MIN_VALUE;
                continue;
            }
            sum = sum + x;
            if (mp.containsKey(sum)) {
                int ind = mp.get(sum);
                int tempSum = sum;
                for (int j = ind + 1; j <= i; j++) {
                    if (arr[j] == 0 || arr[j] == Integer.MIN_VALUE) {
                        continue;
                    }
                    tempSum = tempSum + arr[j];
                    if (mp.containsKey(tempSum) && mp.get(tempSum) > ind + 1) {
                        mp.remove(tempSum);
                    }
                    arr[j] = Integer.MIN_VALUE;
                }
            } else {
                mp.put(sum, i);
            }
        }
        head = null;
        ListNode tail = head;
        for (int x : arr) {
            if (x != Integer.MIN_VALUE) {
                if (head == null) {
                    head = new ListNode(x);
                    tail = head;
                } else {
                    tail.next = new ListNode(x);
                    tail = tail.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Leetcode_1171 obj = new Leetcode_1171();
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(-3);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(4);
        // ListNode fifth = new ListNode(-2);
        // ListNode sixth = new ListNode(-5);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        // fourth.next = fifth;
        // fifth.next = sixth;
        ListNode ans = obj.removeZeroSumSublists(head);
        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
    }
}
