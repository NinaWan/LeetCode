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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0 || null == inorder || inorder.length == 0) {
            return null;
        }

        return divideConquer(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode divideConquer(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        // find the index of root node in inorder array
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                int nodeCountLeft = i - inStart;
                // build left subtree
                root.left = divideConquer(preorder, preStart + 1, preStart + nodeCountLeft, inorder, inStart, i - 1);
                // build right subtree
                root.right = divideConquer(preorder, preStart + nodeCountLeft + 1, preEnd, inorder, i + 1, inEnd);
                break;
            }
        }

        return root;
    }
}