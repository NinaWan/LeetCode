/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // public boolean hasCycle(ListNode head) {
    // if (null == head || null == head.next) return false;
    //
    // Map<ListNode, Boolean> visited = new HashMap<ListNode, Boolean>();
    // ListNode pointer = head;
    // while (null != pointer) {
    // if (null != visited.get(pointer) && visited.get(pointer)) {
    // return true;
    // } else {
    // visited.put(pointer, true);
    // }
    // pointer = pointer.next;
    // }
    // return false;
    // }

    // slow-fast pointer solution
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}