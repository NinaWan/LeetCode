/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode reversedHead = head;
        ListNode leftHead = head.next;
        while (null != leftHead) {
            ListNode temp = leftHead.next;
            leftHead.next = reversedHead;
            reversedHead = leftHead;
            leftHead = temp;
        }
        head.next = null;
        return reversedHead;
    }
}