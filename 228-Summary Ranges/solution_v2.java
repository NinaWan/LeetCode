class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList();

        for (int num : nums) {
            if (ans.isEmpty()) {
                ans.add(String.valueOf(num));
            } else {
                String[] last = ans.get(ans.size() - 1).split("->");
                if (num == Integer.valueOf(last[last.length - 1]) + 1) {
                    ans.set(ans.size() - 1, last[0] + "->" + num);
                } else {
                    ans.add(String.valueOf(num));
                }
            }
        }

        return ans;
    }
}