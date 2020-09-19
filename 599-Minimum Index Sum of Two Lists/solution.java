class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList();
        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]);
                if (min > sum) {
                    ans.clear();
                }

                if (min >= sum) {
                    min = sum;
                    ans.add(list2[j]);
                }
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}