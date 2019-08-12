public class Solution {
    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle || haystack.length() < needle.length()) return -1;
        if (haystack.length() == needle.length() && haystack.equals(needle)) return 0;

        int index = -1;
        boolean flag = true;

        for (int i = 0; i < haystack.length(); i++) {
            flag = true;
            if (i + needle.length() > haystack.length()) {
                break;
            } else {
                for (int j = 0; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}