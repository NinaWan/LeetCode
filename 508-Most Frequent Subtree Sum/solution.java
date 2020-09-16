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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap();
        List<Integer> list = new ArrayList();

        treeSum(root, freq);

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > max) {
                list.clear();
                list.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private int treeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int sum = treeSum(root.left, map) + root.val + treeSum(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }
}