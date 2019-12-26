class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList();
        int[][] occurrence = new int[A.length][26];

        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                occurrence[i][c - 'a']++;
            }
        }

        for (int j = 0; j < 26; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                min = Math.min(min, occurrence[i][j]);
            }
            for (int m = 0; m < min; m++) {
                result.add(String.valueOf((char) ('a' + j)));
            }
        }

        return result;
    }
}