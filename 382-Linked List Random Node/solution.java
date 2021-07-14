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
    private ListNode head;
    private Random random;

    /**
     * @param head
     *            The linked list's head.
     *            Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val;
        int i = 0;
        ListNode p = head;

        while (p != null) {
            if (random.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */