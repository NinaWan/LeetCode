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
    int max;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return max;
    }

    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];// {isBST, min, max, sum}
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(root.val, left[1]);
            res[2] = Math.max(root.val, right[2]);
            res[3] = root.val + left[3] + right[3];
            max = Math.max(max, res[3]);
        } else {
            res[0] = 0;
        }

        return res;
    }
}