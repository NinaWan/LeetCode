class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length() - 1;
        while (left < s2.length() && right < s2.length()) {
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return true;
            } else {
                freq2[s2.charAt(left) - 'a']--;
                left++;
                right++;
                if (right < s2.length()) {
                    freq2[s2.charAt(right) - 'a']++;
                }
            }
        }

        return false;
    }
}