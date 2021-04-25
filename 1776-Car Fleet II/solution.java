class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        double[] ans = new double[cars.length];
        Arrays.fill(ans, -1.0);
        Stack<Integer> stack = new Stack();

        for (int i = cars.length - 1; i >= 0; i--) {
            int p1 = cars[i][0], s1 = cars[i][1];
            while (!stack.isEmpty()) {
                int j = stack.peek();
                int p2 = cars[j][0], s2 = cars[j][1];

                if (s1 > s2 && (ans[j] == -1.0 || 1.0 * (p2 - p1) / (s1 - s2) <= ans[j])) {// can collide
                    ans[i] = 1.0 * (p2 - p1) / (s1 - s2);
                    break;
                }

                stack.pop();
            }

            stack.push(i);
        }

        return ans;
    }
}