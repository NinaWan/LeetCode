/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = pre.next;

        while (curr != null && curr.next != null) {
            Integer value = null;
            if (curr.val == curr.next.val) {
                value = curr.val;
            } else {
                pre = curr;
                curr = pre.next;
            }

            while (curr != null && value != null && curr.val == value) {
                pre.next = curr.next;
                curr = pre.next;
            }
        }

        return dummy.next;
    }
}