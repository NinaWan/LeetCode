/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode oddTail = head;

        while (oddTail != null && oddTail.next != null) {
            ListNode evenNode = oddTail.next;
            oddTail.next = evenNode.next;
            oddTail = oddTail.next == null ? oddTail : oddTail.next;
            evenNode.next = null;

            if (evenHead == null) {
                evenHead = evenNode;
            }

            if (evenTail == null) {
                evenTail = evenNode;
            } else {
                evenTail.next = evenNode;
                evenTail = evenTail.next;
            }
        }

        oddTail.next = evenHead;

        return head;
    }
}