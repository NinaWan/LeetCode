/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        int result = 0;
        Set<Integer> gSet = new HashSet();
        ListNode curr = head;

        for (Integer val : G) {
            gSet.add(val);
        }

        while (curr != null) {
            if (gSet.contains(curr.val) && (curr.next == null || !gSet.contains(curr.next.val))) {
                result++;
            }
            curr = curr.next;
        }

        return result;
    }
}