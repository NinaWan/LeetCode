class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        if (points.length < 3) {
            return points.length;
        }

        int ans = 2;
        // expression for a line: y = (a/b)x+c, a/b=(y1-y2)/(x1-x2)
        for (int i = 0; i < points.length; i++) {
            int dup = 0, max = 1;
            Map<Integer, Map<Integer, Integer>> counter = new HashMap();
            for (int j = i + 1; j < points.length; j++) {
                int a = points[j][1] - points[i][1], b = points[j][0] - points[i][0];
                if (a == 0 && b == 0) {
                    dup++;
                    continue;
                }

                int gcd = gcd(a, b);
                if (gcd != 0) {
                    a /= gcd;
                    b /= gcd;
                }

                Map<Integer, Integer> count = counter.getOrDefault(a, new HashMap());
                count.put(b, count.getOrDefault(b, 1) + 1);
                counter.put(a, count);
                max = Math.max(max, counter.get(a).get(b));
            }
            ans = Math.max(ans, max + dup);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}