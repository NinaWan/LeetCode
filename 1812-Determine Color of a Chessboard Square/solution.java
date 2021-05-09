class Solution {
    public boolean squareIsWhite(String coordinates) {
        char letter = coordinates.charAt(0);
        char number = coordinates.charAt(1);
        return (letter - 'a') % 2 == (number - '0') % 2;
    }
}