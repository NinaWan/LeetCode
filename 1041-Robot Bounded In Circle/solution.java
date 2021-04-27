class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] curr = new int[] {0, 0};
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// up, right, down, left
        int dir = 0;

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                curr[0] += dirs[dir][0];
                curr[1] += dirs[dir][1];
            } else if (instruction == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        return dir != 0 || (curr[0] == 0 && curr[1] == 0);
    }
}