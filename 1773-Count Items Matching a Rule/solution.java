class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;

        for (List<String> item : items) {
            if (("type".equals(ruleKey) && ruleValue.equals(item.get(0))) || ("color".equals(ruleKey) && ruleValue.equals(item.get(1))) ||
                    ("name".equals(ruleKey) && ruleValue.equals(item.get(2)))) {
                ans++;
            }
        }

        return ans;
    }
}