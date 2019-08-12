public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = convertArrayToMap(list1);
        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>> indexSum = new HashMap();

        for (int i = 0; i < list2.length; i++) {
            Integer index = map1.get(list2[i]);
            if (null != index && i + index <= min) {
                min = i + index;
                List<String> sl = indexSum.get(min);
                if (null == sl) sl = new ArrayList();
                sl.add(list2[i]);
                indexSum.put(min, sl);
            }
        }

        List<String> resultList = indexSum.get(min);
        String[] result = new String[resultList.size()];
        resultList.toArray(result);
        return result;
    }

    private Map<String, Integer> convertArrayToMap(String[] list) {
        Map<String, Integer> result = new HashMap();
        for (int i = 0; i < list.length; i++) {
            result.put(list[i], i);
        }
        return result;
    }
}