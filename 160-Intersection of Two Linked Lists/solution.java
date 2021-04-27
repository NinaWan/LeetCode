/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        ListNode result = null;
        int m = getLength(headA);
        int n = getLength(headB);

        if (m == 0 || n == 0)
            return null;
        if (m < n) {
            pointerB = movePointer(pointerB, n - m);
        } else {
            if (m > n) {
                pointerA = movePointer(pointerA, m - n);
            }
        }
        result = pointerA;
        while (pointerA != null) {
            if (pointerA.val != pointerB.val) {
                result = pointerA.next;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return result;
    }

    private int getLength(ListNode head) {
        ListNode tempPointer = head;
        int count = 0;
        while (tempPointer != null) {
            count++;
            tempPointer = tempPointer.next;
        }
        return count;
    }

    private ListNode movePointer(ListNode pointer, int off) {
        ListNode temp = pointer;
        for (int i = 0; i < off; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Solution 2
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (!(headA != null && headB != null)) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (true) {
            if (p1 == null && p2 == null) {
                return null;
            }

            if (p1 == null) {
                p1 = headB;
            }

            if (p2 == null) {
                p2 = headA;
            }

            if (p1 == p2) {
                return p1;
            }

            p1 = p1.next;
            p2 = p2.next;
        }
    }
}