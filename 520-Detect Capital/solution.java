public class Solution {
    public boolean detectCapitalUse(String word) {
        if(null == word || word.length() < 2) return true;

        // The first letter is uppercase
        if('A' <= word.charAt(0) && 'Z' >= word.charAt(0)){
            int upper = -1;
            for(int i=1;i<word.length();i++){
                if(upper == -1){
                    upper = ('A' <= word.charAt(i) && 'Z' >= word.charAt(i))? 1:0;
                }else{
                    if(upper == 1 && 'a' <= word.charAt(i) && 'z' >= word.charAt(i)) return false;
                    if(upper == 0 && 'A' <= word.charAt(i) && 'Z' >= word.charAt(i)) return false;
                }
            }
        }

        // The first letter is lowercase
        if('a' <= word.charAt(0) && 'z' >= word.charAt(0)){
            for(int i=1;i<word.length();i++){
                if('A' <= word.charAt(i) && 'Z' >= word.charAt(i)) return false;
            }
        }

        return true;
    }
}