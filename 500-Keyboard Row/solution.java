public class Solution {
    public String[] findWords(String[] words) {
        // Null or Empty
        if (null == words || 0 == words.length) return words;

        List<String> result = new ArrayList<String>();
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";

        // Loop String array
        for (String word : words) {
            int flag = 0;
            for (String letter : word.split("")) {
                if (line1.contains(letter) || line1.toUpperCase().contains(letter)) {
                    flag = (flag == 0 || flag == 1) ? 1 : 0;
                }

                if (line2.contains(letter) || line2.toUpperCase().contains(letter)) {
                    flag = (flag == 0 || flag == 2) ? 2 : 0;
                }

                if (line3.contains(letter) || line3.toUpperCase().contains(letter)) {
                    flag = (flag == 0 || flag == 3) ? 3 : 0;
                }

                if (flag == 0) break;
            }
            if (flag != 0) {
                result.add(word);
            }
        }

        return result.toArray(new String[result.size()]);
    }
}