/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = mergedList;

        while (p1 != null && p2 != null) {
            ListNode next = null;
            if (p1.val >= p2.val) {
                next = p2;
                p2 = p2.next;
            } else {
                next = p1;
                p1 = p1.next;
            }

            if (p3 == null) {
                mergedList = next;
                p3 = mergedList;
            } else {
                p3.next = next;
                p3 = p3.next;
            }
        }

        while (p1 != null) {
            if (p3 != null) {
                p3.next = p1;
                p3 = p3.next;
            } else {
                mergedList = p1;
                p3 = mergedList;
            }
            p1 = p1.next;
        }

        while (p2 != null) {
            if (p3 != null) {
                p3.next = p2;
                p3 = p3.next;
            } else {
                mergedList = p2;
                p3 = mergedList;
            }
            p2 = p2.next;
        }
        return mergedList;
    }
}