class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            arr[i] = shift(arr[i - 1], arr[i] - '0');
        }

        return new String(arr);
    }

    private char shift(char c, int x) {
        return (char) ((c - 'a' + x) % 26 + 'a');
    }
}