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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (isSubPathFromRoot(head, treeNode)) {
                return true;
            }

            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }

        return false;
    }

    public boolean isSubPathFromRoot(ListNode listNode, TreeNode root) {
        if (root == null && listNode != null) {
            return false;
        }

        if (listNode == null) {
            return true;
        }

        if (listNode.val != root.val) {
            return false;
        }

        return isSubPathFromRoot(listNode.next, root.left) || isSubPathFromRoot(listNode.next, root.right);
    }
}