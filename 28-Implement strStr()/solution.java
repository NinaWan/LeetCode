class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) {
                break;
            }

            boolean isFound = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return i;
            }
        }

        return -1;
    }
}