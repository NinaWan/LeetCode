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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                int leftCount = i - inStart;
                root.left = buildTree(preorder, preStart + 1, preStart + leftCount, inorder, inStart, i - 1);
                root.right = buildTree(preorder, preStart + leftCount + 1, preEnd, inorder, i + 1, inEnd);
                break;
            }
        }

        return root;
    }
}