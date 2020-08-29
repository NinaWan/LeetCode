class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        String ans = S;
        Map<Integer, Pair<String, String>> map = new TreeMap();

        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new Pair(sources[i], targets[i]));
        }

        int diff = 0;
        for (Map.Entry<Integer, Pair<String, String>> entry : map.entrySet()) {
            int key = entry.getKey();
            Pair<String, String> pair = entry.getValue();
            int sourceSize = pair.getKey().length();

            String sub = S.substring(key, key + sourceSize);
            if (sub.equals(pair.getKey())) {
                int left = key + diff;
                int right = key + sourceSize;
                ans = ans.substring(0, left) + pair.getValue() + S.substring(right, S.length());
                diff += pair.getValue().length() - sourceSize;
            }
        }

        return ans;
    }
}