class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList();
        char[] chars = s.toCharArray();
        int[][] letterCount = new int[s.length()][26];

        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                letterCount[i] = Arrays.copyOf(letterCount[i - 1], 26);
            }

            letterCount[i][chars[i] - 'a']++;
        }

        for (int[] query : queries) {
            int change = 0;
            int[] right = letterCount[query[1]];
            int[] left = query[0] == 0 ? new int[26] : letterCount[query[0] - 1];

            for (int i = 0; i < 26; i++) {
                change += (right[i] - left[i]) % 2;
            }

            result.add(change / 2 <= query[2]);
        }

        return result;
    }
}