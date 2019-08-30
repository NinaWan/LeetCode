class Solution {
    public String toLowerCase(String str) {
        if (null == str) {
            return null;
        }

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                result += (char) (str.charAt(i) + ('a' - 'A'));
            } else {
                result += str.charAt(i);
            }
        }

        return result;
    }
}