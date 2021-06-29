/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (poststart > postend) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root.val) {
                int leftCount = i - instart;
                root.left = buildTree(inorder, instart, i - 1, postorder, poststart, poststart + leftCount - 1);
                root.right = buildTree(inorder, i + 1, inend, postorder, poststart + leftCount, postend - 1);
                break;
            }
        }

        return root;
    }
}