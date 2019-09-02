/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return head;
        }

        ListNode current = head;
        ListNode pre = null;
        while (null != current) {
            if (val == current.val) {
                if (null == pre) {
                    head = current.next;
                } else {
                    pre.next = current.next;
                }
            } else {
                pre = current;
            }

            current = current.next;
        }

        return head;
    }
}