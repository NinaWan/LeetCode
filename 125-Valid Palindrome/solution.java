public class Solution {
    public boolean isPalindrome(String s) {
        if(null == s) return false;
        if(s.isEmpty() || 1 == s.length()) return true;
        char[] chars = s.toLowerCase().toCharArray();
        for(int i=0,j=chars.length-1;i<j;i++,j--){
            while(!(('a'<=chars[i] && chars[i]<='z') || ('0'<=chars[i] && chars[i]<='9')) && i<j) i++;
            while(!(('a'<=chars[j] && chars[j]<='z') || ('0'<=chars[j] && chars[j]<='9')) && i<j) j--;
            if(chars[i] != chars[j]) return false;
        }
        return true;
    }
}