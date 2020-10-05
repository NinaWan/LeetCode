class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> ans = new TreeSet();
        Map<String, List<String>> map = new TreeMap();
        for (int i = 0; i < keyName.length; i++) {
            List<String> times = map.getOrDefault(keyName[i], new ArrayList());
            times.add(keyTime[i]);
            map.put(keyName[i], times);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> times = entry.getValue();
            Collections.sort(times);

            for (int i = 0; i < times.size() - 2; i++) {
                String[] t1 = times.get(i).split(":");
                String[] t2 = times.get(i + 2).split(":");
                if (t1[0].equals(t2[0]) || (Integer.valueOf(t1[0]).equals(Integer.valueOf(t2[0]) - 1) && Integer.valueOf(t2[1]) <= Integer.valueOf(t1[1]))) {
                    ans.add(entry.getKey());
                    break;
                }
            }
        }

        return new ArrayList(ans);
    }
}