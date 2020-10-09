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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;

        while (k > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode top = stack.pop();
            k--;
            if (k == 0) {
                return top.val;
            }

            curr = top.right;
        }

        return root.val;
    }
}