class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int result = 0;
        Map<Character, Integer> counter = new HashMap();

        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            if (counter.getOrDefault(chars[right], 0) != 0) {
                result = Math.max(result, right - left);

                while (left < right && chars[left] != chars[right]) {
                    counter.put(chars[left], counter.get(chars[left]) - 1);
                    left++;
                }
                left++;
            } else {
                counter.put(chars[right], 1);
            }
            right++;
        }

        return Math.max(result, right - left);
    }
}