class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap();
        Set<Character> dup = new HashSet();

        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            char rkey = s.charAt(right);
            freq.put(rkey, freq.getOrDefault(rkey, 0) + 1);
            if (freq.get(rkey) > 1) {
                dup.add(rkey);
            }

            while (dup.size() != 0) {
                char lKey = s.charAt(left);
                freq.put(lKey, Math.max(0, freq.get(lKey) - 1));
                if (freq.get(lKey) < 2) {
                    dup.remove(lKey);
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}