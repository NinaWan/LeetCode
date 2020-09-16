class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String ans = "";
        Map<String, String> map = new HashMap();
        Collections.sort(dictionary);

        for (String word : sentence.split(" ")) {
            if (map.containsKey(word)) {
                ans += map.get(word) + " ";
            } else {
                String s = word;
                for (String root : dictionary) {
                    if (word.startsWith(root)) {
                        s = root;
                        break;
                    }
                }

                map.put(word, s);
                ans += s + " ";
            }
        }

        return ans.trim();
    }
}