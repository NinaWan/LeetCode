public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;

        int quotient = n;
        while(quotient%2 == 0){
            quotient = quotient/2;
        }
        if(quotient == 1) return true;
        return false;
    }
}