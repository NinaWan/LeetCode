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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        ListNode pa = list1, pb = list1;
        for (int i = 1; i < a; i++) {
            pa = pa.next;
            pb = pb.next;
        }
        for (int j = a; j <= b + 1; j++) {
            pb = pb.next;
        }

        pa.next = list2;
        tail2.next = pb;

        return list1;
    }
}