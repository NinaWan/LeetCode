class Solution {
    public boolean judgeCircle(String moves) {
        if (null == moves || moves.length() == 0) {
            return true;
        }

        int left = 0, right = 0, up = 0, down = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    up++;
                    break;
                case 'D':
                    down++;
                    break;
                case 'L':
                    left++;
                    break;
                case 'R':
                    right++;
                    break;
            }
        }

        return (left == right) && (up == down);
    }
}