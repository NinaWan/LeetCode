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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        divideConquer(root);
        return this.maxSum;
    }

    public int divideConquer(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftMaxSum = Math.max(divideConquer(root.left), 0);
        int rightMaxSum = Math.max(divideConquer(root.right), 0);

        maxSum = Math.max(leftMaxSum + rightMaxSum + root.val, maxSum);

        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}