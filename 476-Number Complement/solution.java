public class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;

        int result = 0;
        int quotient = num;
        int count = 0;
        while(quotient != 0){
            result += Math.pow(2, count)*(quotient%2==0? 1:0);
            quotient = quotient/2;
            count++;
        }
        return result;
    }
}