class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int sum = 0;
        int count = 0;
        Map<Integer, Map<Integer, Integer>> map = new TreeMap(Collections.reverseOrder());
        Map<Integer, Integer> used = new HashMap();

        for (int i = 0; i < values.length; i++) {
            Map<Integer, Integer> freq = map.getOrDefault(values[i], new HashMap());
            freq.put(labels[i], freq.getOrDefault(labels[i], 0) + 1);
            map.put(values[i], freq);
        }

        for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
            int value = entry.getKey();
            for (Map.Entry<Integer, Integer> e : entry.getValue().entrySet()) {
                int label = e.getKey();
                int num = used.getOrDefault(label, 0);

                if (num == use_limit) {
                    continue;
                }

                num = Math.min(e.getValue(), use_limit - num);
                num = count + num > num_wanted ? num_wanted - count
                                               : num;

                sum += value * num;
                count += num;
                used.put(label, used.getOrDefault(label, 0) + num);

                if (count >= num_wanted) {
                    break;
                }
            }

            if (count >= num_wanted) {
                break;
            }
        }

        return sum;
    }
}