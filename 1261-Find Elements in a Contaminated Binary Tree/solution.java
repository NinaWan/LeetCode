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
class FindElements {
    private Set<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet();
        root.val = 0;
        values.add(0);
        recover(root.left, values, 2 * root.val + 1);
        recover(root.right, values, 2 * root.val + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }

    private void recover(TreeNode root, Set<Integer> values, int val) {
        if (root == null) {
            return;
        }

        root.val = val;
        values.add(val);
        recover(root.left, values, 2 * root.val + 1);
        recover(root.right, values, 2 * root.val + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */