/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> vals = new ArrayList();
        Stack<Integer> indexes = new Stack();

        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        int[] result = new int[vals.size()];

        for (int i = 0; i < vals.size(); i++) {
            while (!indexes.isEmpty() && vals.get(indexes.peek()) < vals.get(i)) {
                result[indexes.pop()] = vals.get(i);
            }

            indexes.push(i);
        }

        return result;
    }
}