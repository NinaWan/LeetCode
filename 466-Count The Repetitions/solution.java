class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;
        while (count1 < n1) {
            if (c1[i] == c2[j]) {
                j++;
                if (j == s2.length()) {
                    j = 0;
                    count2++;
                }
            }

            i++;

            if (i == s1.length()) {
                i = 0;
                count1++;
            }
        }

        return count2 / n2;
    }
}