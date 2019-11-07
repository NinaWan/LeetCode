/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        mergeLists(head, reverseList(findMiddle(head)));
    }

    public void mergeLists(ListNode ordered, ListNode reversed) {
        int count = 0;
        ListNode tail = new ListNode(0);
        while (ordered != null || reversed != null) {
            if (ordered == null) {
                tail.next = reversed;
                break;
            }

            if (reversed == null) {
                tail.next = ordered;
                break;
            }

            if (count % 2 == 0) {
                tail.next = ordered;
                ordered = ordered.next;
            } else {
                tail.next = reversed;
                reversed = reversed.next;
            }

            tail = tail.next;
            count++;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = pre.next;
        pre.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(0);

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        return slow;
    }
}