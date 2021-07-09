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
    private TreeNode dummy;
    private TreeNode p;

    public TreeNode increasingBST(TreeNode root) {
        dummy = new TreeNode(0);
        p = dummy;
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        p.right = root;
        p = p.right;
        p.left = null;
        inOrder(root.right);
    }
}