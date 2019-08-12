/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the center of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the second half of the list
        ListNode secondHead = slow.next;
        ListNode previous = secondHead;
        ListNode latter = previous.next;
        ListNode temp;
        while (latter != null) {
            temp = latter;
            latter = latter.next;
            temp.next = previous;
            previous = temp;
        }
        secondHead.next = null;

        // Compare these two lists
        ListNode p1 = head;
        ListNode p2 = previous;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null || p2 == null) {
            return true;
        }
        return false;
    }
}