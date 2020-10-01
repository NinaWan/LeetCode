class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList();
        int level = 1;

        while (Math.pow(2, level) - 1 < label) {
            level++;
        }

        level--;
        while (level >= 0) {
            ans.add(0, label);
            int diff = (int) (label - Math.pow(2, level));
            label -= diff + 1 + diff / 2;
            level--;
        }

        return ans;
    }
}