class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList();
        int[][] criticalPoints = new int[buildings.length * 2][2];
        int p = 0;
        for (int[] building : buildings) {
            criticalPoints[p++] = new int[] {building[0], -building[2]};// left point
            criticalPoints[p++] = new int[] {building[1], building[2]};// right point
        }

        // sort by ascending of x, then ascending of second element
        // for the second level sorting, we have 3 cases:
        // case 1: sort 2 left points, then by descending of their heights
        // case 2: sort 2 right points, then by ascending of their heights
        // case 3: sort 1 left point and 1 right point, then left point always comes first
        Arrays.sort(criticalPoints, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        queue.offer(0);
        int prev = 0;
        for (int[] criticalPoint : criticalPoints) {
            if (criticalPoint[1] < 0) {// left point
                queue.offer(-criticalPoint[1]);
            } else {// right point
                queue.remove(criticalPoint[1]);
            }

            int curr = queue.peek();
            if (curr != prev) {// if the max height changed
                List<Integer> point = new ArrayList() {
                    {
                        add(criticalPoint[0]);
                        add(curr);
                    }
                };
                ans.add(point);
                prev = curr;
            }
        }

        return ans;
    }
}