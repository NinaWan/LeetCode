/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE,
                                      head);
        ListNode curr = head.next;
        head.next = null;

        while (curr != null) {
            ListNode pre = dummy, next = dummy.next, nextCurr = curr.next;
            while (pre != null) {
                if (next == null || next.val > curr.val) {
                    pre.next = curr;
                    curr.next = next;
                    break;
                } else {
                    ListNode temp = next.next;
                    pre = next;
                    next = temp;
                }
            }
            curr = nextCurr;
        }

        return dummy.next;
    }
}