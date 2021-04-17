class Solution {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        String ans = S;
        for (int i = 1; i < S.length(); i++) {
            String rotate = S.substring(i) + S.substring(0, i);
            ans = ans.compareTo(rotate) > 0 ? rotate
                                            : ans;
        }

        return ans;
    }
}