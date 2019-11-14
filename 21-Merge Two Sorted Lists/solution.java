/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = null;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                break;
            }

            if (l2 == null) {
                p.next = l1;
                break;
            }

            if (l1.val < l2.val) {
                if (p == null) {
                    p = l1;
                    dummy.next = p;
                } else {
                    p.next = l1;
                    p = l1;
                }
                l1 = l1.next;
            } else {
                if (p == null) {
                    p = l2;
                    dummy.next = p;
                } else {
                    p.next = l2;
                    p = l2;
                }
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}