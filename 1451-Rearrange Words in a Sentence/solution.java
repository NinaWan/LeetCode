class Solution {
    public String arrangeWords(String text) {
        String result = "";
        String[] words = text.toLowerCase().split(" ");
        Map<Integer, List<String>> map = new TreeMap();

        for (String word : words) {
            int key = word.length();
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(word);
            map.put(key, list);
        }

        for (List<String> l : map.values()) {
            for (String word : l) {
                if (result.isEmpty()) {
                    result = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
                } else {
                    result += " " + word;
                }
            }
        }

        return result;
    }
}