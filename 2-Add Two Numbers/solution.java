/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2
                              : l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = null;
        int pre = 0;
        int remain = 0;
        int sum = 0;

        while (l1 != null || l2 != null || pre != 0) {
            if (l1 == null && l2 == null) {
                p.next = new ListNode(pre);
                break;
            }

            if (l1 == null) {
                sum = l2.val + pre;
                p.next = new ListNode(sum % 10);
                p = p.next;
            }

            if (l2 == null) {
                sum = l1.val + pre;
                p.next = new ListNode(sum % 10);
                p = p.next;
            }

            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + pre;

                if (p == null) {
                    p = new ListNode(sum % 10);
                    dummy.next = p;
                } else {
                    p.next = new ListNode(sum % 10);
                    p = p.next;
                }
            }

            pre = sum / 10;
            l1 = l1 == null ? null
                            : l1.next;
            l2 = l2 == null ? null
                            : l2.next;
        }

        return dummy.next;
    }
}