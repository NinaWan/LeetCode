class Solution {
    public int numJewelsInStones(String J, String S) {
        if (null == J || null == S) {
            return 0;
        }

        int result = 0;

        Set<String> setJ = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            setJ.add(J.charAt(i) + "");
        }

        for (int j = 0; j < S.length(); j++) {
            if (setJ.contains(S.charAt(j) + "")) {
                result++;
            }
        }

        return result;
    }
}