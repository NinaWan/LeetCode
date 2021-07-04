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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList();
        traverse(root, ans, new HashMap());
        return ans;
    }

    private String traverse(TreeNode root, List<TreeNode> res, Map<String, Integer> freq) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left, res, freq);
        String right = traverse(root.right, res, freq);

        String sub = left + "," + right + "," + root.val;
        int count = freq.getOrDefault(sub, 0);
        if (count == 1) {
            res.add(root);
        }
        freq.put(sub, count + 1);

        return sub;
    }
}