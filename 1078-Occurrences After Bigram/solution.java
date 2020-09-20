class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList();
        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                ans.add(words[i + 2]);
                i++;
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}