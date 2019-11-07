/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode beforeTail = null;
        ListNode afterTail = null;

        while (head != null) {
            if (head.val < x) {
                if (beforeTail == null) {
                    beforeTail = head;
                    dummy1.next = beforeTail;
                } else {
                    beforeTail.next = head;
                    beforeTail = beforeTail.next;
                }
            } else {
                if (afterTail == null) {
                    afterTail = head;
                    dummy2.next = afterTail;
                } else {
                    afterTail.next = head;
                    afterTail = afterTail.next;
                }
            }

            head = head.next;
        }


        // combine
        if (afterTail != null) {
            afterTail.next = null;
        }

        if (beforeTail != null) {
            beforeTail.next = afterTail == null ? null : dummy2.next;
            return dummy1.next;
        } else {
            return dummy2.next;
        }
    }
}