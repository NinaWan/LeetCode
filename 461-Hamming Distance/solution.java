public class Solution {
    public int hammingDistance(int x, int y) {
        int number = x ^ y;
        int count = 0;

        int quotient = number;
        int remainder;

        while(quotient != 0){
            quotient = number/2;
            remainder = number%2;
            if(remainder == 1){
                count += 1;
            }
            number = quotient;
        }
        return count;
    }
}