class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (null == strs || strs.length == 0) {
            return result;
        }

        boolean isDone = false;
        for (int i = 0; !isDone; i++) {
            if (i >= strs[0].length()) {
                isDone = true;
                continue;
            }

            char c = strs[0].charAt(i);
            result += String.valueOf(c);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    result = result.substring(0, result.length() - 1);
                    isDone = true;
                    break;
                }
            }
        }

        return result;
    }
}