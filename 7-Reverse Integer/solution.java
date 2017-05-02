import java.lang.Math;

public class Solution {
    public int reverse(int x) {
        String s = String.valueOf(Math.abs(x));
        String reverseString = "";
        Integer result;

        for(int i=s.length()-1; i>=0; i--){
            reverseString += s.charAt(i);
        }

        try{
            result = Integer.valueOf(reverseString);
        }catch(Exception e){
            return 0;
        }
        if(x < 0) return -result;
        return result;
    }
}