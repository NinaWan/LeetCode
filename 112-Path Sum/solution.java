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
    public boolean hasPathSum(TreeNode root, int sum) {

        if (null == root) {
            return false;
        }

        if (null == root.left && null == root.right) {
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        }

        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);

        return left || right;
    }
}