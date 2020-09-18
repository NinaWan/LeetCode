class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> map = new TreeMap();
        List<List<String>> ans = new ArrayList();
        Set<String> foods = new TreeSet();

        for (List<String> order : orders) {
            int table = Integer.valueOf(order.get(1));
            String food = order.get(2);

            foods.add(food);
            Map<String, Integer> freq = map.getOrDefault(table, new HashMap());
            freq.put(food, freq.getOrDefault(food, 0) + 1);
            map.put(table, freq);
        }

        List<String> header = new ArrayList();
        header.add("Table");
        header.addAll(foods);
        ans.add(header);

        for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            List<String> row = new ArrayList();
            row.add(String.valueOf(entry.getKey()));
            Map<String, Integer> items = entry.getValue();
            for (String food : foods) {
                row.add(String.valueOf(items.getOrDefault(food, 0)));
            }
            ans.add(row);
        }

        return ans;
    }
}