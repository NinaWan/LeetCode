public class Solution {
    public double myPow(double x, int n) {
        double cross = 1;
        for(int i = 0; i < n; i++){
            cross = cross * x;
        }
        return cross;
    }
}