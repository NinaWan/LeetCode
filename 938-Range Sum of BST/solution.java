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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (null == root) {
            return 0;
        }

        int result = 0;
        if (root.val <= R && root.val >= L) {
            result += root.val;
        }

        result += rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

        return result;
    }
}