class Solution {
    public int numSteps(String s) {
        int result = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {// division by two is same as right shift by one bit (i.e. move one char from right to left)
            result++; // plus one for odd, divide by 2 for even
            if (s.charAt(i) - '0' + carry == 1) { // if is odd after operation, plus one for divide by 2 before shifting
                carry = 1;
                result++;
            }
        }

        return result + carry;
    }
}