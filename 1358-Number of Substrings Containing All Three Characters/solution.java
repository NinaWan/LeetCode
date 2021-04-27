class Solution {
    public int numberOfSubstrings(String s) {
        int result = 0;
        int[] count = new int[3];
        int p = 0;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(p) - 'a']--;
                p++;
            }
            result += p;
        }

        return result;
    }
}