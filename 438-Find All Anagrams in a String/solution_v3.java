class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList();
        }

        int[] freqP = new int[26], freqS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
            freqS[s.charAt(i) - 'a']++;
        }

        int left = 0, right = p.length() - 1;
        List<Integer> ans = new ArrayList();
        while (right < s.length()) {
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (freqS[i] != freqP[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                ans.add(left);
            }

            freqS[s.charAt(left) - 'a']--;
            left++;
            right++;
            if (right < s.length()) {
                freqS[s.charAt(right) - 'a']++;
            }
        }

        return ans;
    }
}