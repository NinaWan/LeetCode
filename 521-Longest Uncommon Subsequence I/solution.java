public class Solution {
    public int findLUSlength(String a, String b) {
        int result = -1;
        if(a != null && b != null && !(a.isEmpty() && b.isEmpty())){
            if(a.length() != b.length()) return a.length()>b.length()? a.length():b.length();
            if(!a.equals(b)) return a.length();
        }
        return result;
    }
}