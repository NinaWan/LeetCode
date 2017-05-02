public class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] nums = new int[52];

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) > 90){//lower case
                nums[s.charAt(i)-71] += 1;
            }else{//upper case
                nums[s.charAt(i)-65] += 1;
            }
        }

        //loop nums
        for(int i=0; i<52; i++){
            if(nums[i] > 1){
                result += (nums[i]/2)*2;
                if(result%2 == 0 && nums[i]%2 == 1){
                    result += 1;
                }
            }
            if(nums[i] == 1 && result%2 == 0){
                result += 1;
            }
        }

        return result;
    }
}