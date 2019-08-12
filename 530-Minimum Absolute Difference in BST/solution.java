/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        // In-order traversal
        List<Integer> inOrderList = new ArrayList<Integer>();
        inOrderTraversal(inOrderList, root);
        // Loop in-order list
        for (int i = 0; i < inOrderList.size() - 1; i++) {
            int currentDiff = Math.abs(inOrderList.get(i) - inOrderList.get(i + 1));
            if (result > currentDiff) {
                result = currentDiff;
            }
        }
        return result;
    }

    private void inOrderTraversal(List<Integer> inOrderList, TreeNode root) {
        if (root == null) return;
        inOrderTraversal(inOrderList, root.left);
        inOrderList.add(root.val);
        inOrderTraversal(inOrderList, root.right);
    }
}