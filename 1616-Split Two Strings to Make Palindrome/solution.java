class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(b, a) || check(a, b);
    }

    private boolean check(String pre, String suf) {
        int i = 0, j = pre.length() - 1;
        while (i < j && pre.charAt(i) == suf.charAt(j)) {
            i++;
            j--;
        }

        return isPalindrome(pre, i, j) || isPalindrome(suf, i, j);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}