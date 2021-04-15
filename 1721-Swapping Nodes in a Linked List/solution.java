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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list = new ArrayList();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        int m = list.size() - k + 1, tmp = list.get(k - 1);
        list.set(k - 1, list.get(m - 1));
        list.set(m - 1, tmp);

        ListNode dump = new ListNode(0);
        p = dump;
        for (int val : list) {
            ListNode node = new ListNode(val);
            p.next = node;
            p = node;
        }

        return dump.next;
    }
}