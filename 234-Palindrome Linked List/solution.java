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
    public boolean isPalindrome(ListNode head) {
        ListNode q = reverse(findCenter(head));
        ListNode p = head;

        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }

    private ListNode findCenter(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, nxt = head;

        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}