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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        List<List<Integer>> ans = new ArrayList();
        Map<Integer, Map<Integer, Set<Integer>>> map = new TreeMap();

        verticalTraversal(0, 0, root, map);

        for (Map<Integer, Set<Integer>> yMap : map.values()) {
            List<Integer> list = new ArrayList();
            for (Set<Integer> set : yMap.values()) {
                list.addAll(set);
            }
            ans.add(list);
        }

        return ans;
    }

    private void verticalTraversal(int x, int y, TreeNode root, Map<Integer, Map<Integer, Set<Integer>>> xMap) {
        if (root == null) {
            return;
        }

        Map<Integer, Set<Integer>> yMap = xMap.getOrDefault(x, new TreeMap(Collections.reverseOrder()));
        Set<Integer> set = yMap.getOrDefault(y, new TreeSet());
        set.add(root.val);
        yMap.put(y, set);
        xMap.put(x, yMap);

        verticalTraversal(x - 1, y - 1, root.left, xMap);
        verticalTraversal(x + 1, y - 1, root.right, xMap);
    }
}