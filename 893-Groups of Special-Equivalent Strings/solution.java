class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet();

        for (String s : A) {
            int[][] letters = new int[2][26];
            for (int i = 0; i < s.length(); i++) {
                letters[i % 2][s.charAt(i) - 'a']++;
            }

            String key = "";
            for (int i = 0; i < 26; i++) {
                key += String.valueOf(letters[0][i]) + String.valueOf(letters[1][i]);
            }
            set.add(key);
        }

        return set.size();
    }
}