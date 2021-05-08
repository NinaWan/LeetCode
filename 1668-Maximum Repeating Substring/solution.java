class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        String repeating = word;

        while (sequence.indexOf(repeating) != -1) {
            ans++;
            repeating += word;
        }

        return ans;
    }
}