public class Solution {
    public String reverseStr(String s, int k) {
        if(null == s || k <= 0) return s;

        char[] result = s.toCharArray();
        for(int i=0; i<s.length(); i+=2*k){
            if(i+2*k<s.length() || (i+2*k>=s.length() && i+k<s.length())){
                reverseSubstr(result, i, i+k-1);
                continue;
            }

            reverseSubstr(result, i, s.length()-1);
        }
        return String.valueOf(result);
    }

    private void reverseSubstr(char[] chars, int start, int end){
        for(int i=start,j=end; i<j; i++, j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}