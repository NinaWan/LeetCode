class Solution {
    public int totalFruit(int[] tree) {
        int ans = 0;
        Set<Integer> basket = new HashSet();
        int left = 0;
        int right = 0;

        while (right < tree.length) {
            if (basket.size() == 2 && !basket.contains(tree[right])) {
                ans = Math.max(ans, right - left);
                left++;
                right = left;
                basket.clear();
            } else {
                basket.add(tree[right]);
                right++;
                if (right == tree.length) {
                    ans = Math.max(ans, right - left);
                }
            }
        }

        return ans;
    }
}