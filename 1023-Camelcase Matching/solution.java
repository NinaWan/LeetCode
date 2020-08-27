class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList();
        char[] chars = pattern.toCharArray();

        for (String query : queries) {
            int p = 0;
            boolean isValid = true;

            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                if (p < chars.length && c == chars[p]) {
                    p++;
                } else if (c <= 'Z' && c >= 'A') {
                    isValid = false;
                    break;
                }
            }

            if (p == chars.length && isValid) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}