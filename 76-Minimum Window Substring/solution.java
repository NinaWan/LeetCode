class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.equals("") || s.equals("") || s.length() < t.length()) {
            return "";
        }

        int[] ans = {-1, 0, 0};//{window length, left index, right index}
        Map<Character, Integer> freqT = new HashMap();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, needed = freqT.size(), formed = 0;
        Map<Character, Integer> freqW = new HashMap();
        while (right < s.length()) {
            char c = s.charAt(right);
            freqW.put(c, freqW.getOrDefault(c, 0) + 1);

            if (freqT.containsKey(c) && freqT.get(c).compareTo(freqW.get(c)) == 0) {
                formed++;
            }

            while (left <= right && formed == needed) {
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                c = s.charAt(left);
                freqW.put(c, freqW.get(c) - 1);
                if (freqT.containsKey(c) && freqW.get(c).compareTo(freqT.get(c)) < 0) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}