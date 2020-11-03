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
    public int pathSum(TreeNode root, int sum) {
        if (null == root)
            return 0;
        int rel = traverse(root, sum);
        rel += pathSum(root.left, sum);
        rel += pathSum(root.right, sum);
        return rel;
    }

    private int traverse(TreeNode root, int sum) {
        int result = 0;
        if (null == root)
            return result;
        if (root.val == sum)
            result += 1;
        result += traverse(root.left, sum - root.val);
        result += traverse(root.right, sum - root.val);
        return result;
    }
}