class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (n == 1 || flights.length == 0) {
            return -1;
        }

        Map<Integer, Map<Integer, Integer>> prices = new HashMap();// from->to->price
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            Map<Integer, Integer> map = prices.getOrDefault(from, new HashMap());
            map.put(to, price);
            prices.put(from, map);
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] {0, src, k + 1});// price, to, stops
        HashMap<Integer, int[]> seen = new HashMap();// to->(price, stops)
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int price = top[0], to = top[1], stops = top[2];
            if (to == dst) {
                return price;
            }

            if (seen.containsKey(to) && seen.get(to)[0] < price && seen.get(to)[1] >= stops) {
                continue;
            }

            seen.put(to, new int[] {price, stops});

            if (stops > 0) {
                for (Map.Entry<Integer, Integer> entry : prices.getOrDefault(to, new HashMap<Integer, Integer>()).entrySet()) {
                    queue.offer(new int[] {price + entry.getValue(), entry.getKey(), stops - 1});
                }
            }
        }

        return -1;
    }
}