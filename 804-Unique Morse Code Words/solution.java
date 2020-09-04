class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mapping = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> trans = new HashSet();

        for (String word : words) {
            String code = "";
            for (char c : word.toCharArray()) {
                code += mapping[c - 'a'];
            }
            trans.add(code);
        }

        return trans.size();
    }
}