class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0] + "/";
            for (int i = 1; i < parts.length; i++) {
                int p = parts[i].indexOf("(");
                String name = parts[i].substring(0, p);
                String content = parts[i].substring(p + 1, parts[i].length() - 1);
                List<String> list = map.getOrDefault(content, new ArrayList());
                list.add(dir + name);
                map.put(content, list);
            }
        }

        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }

        return result;
    }
}