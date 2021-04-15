class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap();
        for (List<String> entry : knowledge) {
            map.put(entry.get(0), entry.get(1));
        }

        String ans = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                String key = "";
                i++;
                while (chars[i] != ')') {
                    key += chars[i];
                    i++;
                }
                ans += map.getOrDefault(key, "?");
            } else {
                ans += chars[i];
            }
        }

        return ans;
    }
}