class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || A.length() != B.length()) {
            return false;
        }

        int[] freqA = new int[26];
        int[] freqB = new int[26];
        int letterA = 0;
        int diff = 0;
        int dupA = 0;
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            if (freqA[a - 'a'] == 0) {
                letterA++;
            } else {
                dupA++;
            }

            if (a != b) {
                diff++;
            }

            freqA[a - 'a']++;
            freqB[b - 'a']++;
        }

        if (diff > 2 || diff == 1) {
            return false;
        }

        if (diff == 0) {// A and B are same
            if (letterA == 1 || dupA != 0) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) {
                return false;
            }
        }

        return true;
    }
}