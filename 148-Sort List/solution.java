/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return mergeSortedList(left, right);
    }

    public ListNode mergeSortedList(ListNode left, ListNode right) {
        ListNode mergedDummy = new ListNode(0);
        ListNode mergedTail = mergedDummy;

        while (left != null || right != null) {
            if (left == null) {
                mergedTail.next = right;
                break;
            }

            if (right == null) {
                mergedTail.next = left;
                break;
            }

            if (left.val < right.val) {
                mergedTail.next = left;
                left = left.next;
            } else {
                mergedTail.next = right;
                right = right.next;
            }

            mergedTail = mergedTail.next;
        }

        return mergedDummy.next;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(0);
        pre.next = slow;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        return slow;
    }
}