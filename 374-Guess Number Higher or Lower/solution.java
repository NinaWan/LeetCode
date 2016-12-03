/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n<1) return 0;
        if(n == 1) return 1;
        int low = 1;
        int high = n;
        int result = (high - low)/2 + low;
        int temp = guess(result);
        while(temp != 0){
            if(temp == 1){
                low = result+1;
            }else{
                high = result-1;
            }
            result = (high - low)/2 + low;
            temp = guess(result);
        }
        return result;
    }
}