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
    int maxDepth = -1;
    TreeNode result;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (null == root) {
            return root;
        }

        calculateMaxDepth(root, 0);

        return result;
    }

    // divide & conquer
    public int calculateMaxDepth(TreeNode node, int currentDepth) {
        if (null == node.left && null == node.right) {
            if (maxDepth < currentDepth) {
                result = node;
                maxDepth = currentDepth;
            }

            return currentDepth;
        }

        int leftMaxDepth = 0, rightMaxDepth = 0;

        if (null != node.left) {
            leftMaxDepth = calculateMaxDepth(node.left, currentDepth + 1);
        }


        if (null != node.right) {
            rightMaxDepth = calculateMaxDepth(node.right, currentDepth + 1);
        }

        if (leftMaxDepth == rightMaxDepth && leftMaxDepth >= maxDepth) {
            maxDepth = leftMaxDepth;
            result = node;
        }

        return Math.max(leftMaxDepth, rightMaxDepth);
    }
}