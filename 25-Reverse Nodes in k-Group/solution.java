/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preTail = dummy;
        ListNode currTail = dummy.next;
        ListNode preP = dummy.next;
        ListNode currP = preP.next;

        while (head != null) {
            length++;
            head = head.next;
        }

        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode temp = currP.next;
                currP.next = preP;
                preP = currP;
                currP = temp;
            }
            preTail.next = preP;
            currTail.next = currP;
            preTail = currTail;
            currTail = currP;
            preP = currP;
            currP = preP == null ? null
                                 : preP.next;
        }

        return dummy.next;
    }
}