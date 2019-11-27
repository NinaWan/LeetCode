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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        return divideConquer(inorder, 0, inorder.length - 1, postorder, postorder.length - 1, 0);
    }

    public TreeNode divideConquer(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart < postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postStart]);

        for (int i = inStart; i <= inEnd; i++) {
            int nodeLeft = i - inStart;
            int nodeRight = inEnd - i;

            if (inorder[i] == root.val) {
                root.left = divideConquer(inorder, inStart, i - 1, postorder, postEnd + nodeLeft - 1, postEnd);
                root.right = divideConquer(inorder, i + 1, inEnd, postorder, postStart - 1, postStart - nodeRight);
                break;
            }
        }

        return root;
    }
}