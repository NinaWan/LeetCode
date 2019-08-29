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
    public boolean isUnivalTree(TreeNode root) {
        if (null == root) {
            return true;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.val != root.val) {
                return false;
            }

            if (null != current.left) {
                stack.push(current.left);
            }

            if (null != current.right) {
                stack.push(current.right);
            }
        }

        return true;
    }
}