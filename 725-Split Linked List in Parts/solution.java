/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }

        ListNode[] result = new ListNode[k];
        ListNode curr = root;
        int length = 0;

        while (curr != null) {
            curr = curr.next;
            length++;
        }

        int leftNum = length % k;
        int elementNum = length / k;
        curr = root;

        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            int threshold = elementNum;
            if (i < leftNum) {
                threshold += 1;
            }

            for (int j = 0; j < threshold - 1; j++) {
                if (curr == null) {
                    break;
                } else {
                    curr = curr.next;
                }
            }

            if (curr != null) {
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
            }

            result[i] = head;
        }

        return result;
    }
}