class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            int diff = chars1[i] - chars2[i];
            if (diff > 0) {
                c1++;
            } else if (diff < 0) {
                c2++;
            }
        }

        return c1 * c2 == 0 ? true : false;
    }
}