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
    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        swapValue(first, second);
    }

    private void inorderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraverse(node.left);

        if (first == null && prev.val > node.val) {
            first = prev;
        }

        if (first != null && prev.val > node.val) {
            second = node;
        }

        prev = node;

        inorderTraverse(node.right);
    }

    private void swapValue(TreeNode first, TreeNode second) {
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}