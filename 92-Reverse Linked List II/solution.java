/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int move = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        // point to the node just before the mth node
        while (move < m) {
            if (curr.next == null) {
                return head;
            }

            curr = curr.next;
            move++;
        }

        ListNode nodeBeforeM = curr;
        ListNode pre = curr.next;
        ListNode nodeM = pre;
        curr = pre != null ? pre.next
                           : null;
        pre.next = null;

        // move == m
        while (move < n) {
            if (curr != null) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            } else {
                break;
            }

            move++;
        }

        if (curr != null) {
            nodeM.next = curr;
        }

        nodeBeforeM.next = pre;

        return dummy.next;
    }
}