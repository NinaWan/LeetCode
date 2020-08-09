class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int[] result = new int[k];

        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        Map<Integer, Queue<Integer>> absIndex = new TreeMap(Collections.reverseOrder());

        for (int num : arr) {
            int key = Math.abs(num - median);
            if (!absIndex.containsKey(key)) {
                absIndex.put(key, new PriorityQueue(Collections.reverseOrder()));
            }

            absIndex.get(key).offer(num);
        }

        int i = 0;
        for (Map.Entry entry : absIndex.entrySet()) {
            if (i >= k) {
                break;
            }

            Queue<Integer> queue = (PriorityQueue<Integer>) entry.getValue();
            while (!queue.isEmpty() && i < k) {
                result[i++] = queue.poll();
            }
        }

        return result;
    }
}