public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1; i<=s.length()/2; i++){
            if(s.length()%i != 0) continue;
            String temp = s;
            String subStr = s.substring(0,i);
            temp = temp.replaceAll(subStr,"");
            if(temp.isEmpty()){
                return true;
            }
        }
        return false;
    }
}