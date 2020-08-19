class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> suffixMap = new HashMap();
        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];

            if (suffixMap.containsKey(name)) {
                int k = suffixMap.get(name);
                String tmp = name + "(" + k + ")";
                while (suffixMap.containsKey(tmp)) {
                    k++;
                    tmp = name + "(" + k + ")";
                }
                suffixMap.put(name, k + 1);
                name = tmp;
            }

            suffixMap.put(name, 1);
            result[i] = name;
        }

        return result;
    }
}