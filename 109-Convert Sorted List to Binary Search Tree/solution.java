/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        return sortedListToBST(list, 0, list.size() - 1);
    }

    public TreeNode sortedListToBST(List<ListNode> list, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(list.get(start).val);
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = sortedListToBST(list, start, mid - 1);
        root.right = sortedListToBST(list, mid + 1, end);

        return root;
    }
}