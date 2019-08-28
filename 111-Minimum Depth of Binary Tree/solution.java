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
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        minDepth(root, 1);

        return minDepth;
    }

    public int minDepth(TreeNode node, int currentDepth) {
        if (null == node.left && null == node.right) {
            if (minDepth > currentDepth) {
                minDepth = currentDepth;
            }
            return currentDepth;
        }

        int leftMinDepth = 0, rightMinDepth = 0;

        if (null != node.left) {
            leftMinDepth = minDepth(node.left, currentDepth + 1);
        }


        if (null != node.right) {
            rightMinDepth = minDepth(node.right, currentDepth + 1);
        }

        return Math.min(leftMinDepth, rightMinDepth);
    }
}