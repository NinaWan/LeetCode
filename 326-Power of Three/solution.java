public class Solution {
    public boolean isPowerOfThree(int n) {
        int result = n;
        if(n <= 0 || n==2) return false;
        if(n == 1) return true;
        while(result > 1){
            if(result%3 != 0) return false;
            result /= 3;
        }
        return true;
    }
}