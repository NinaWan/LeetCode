class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        List<String> morseCodes = new ArrayList(Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."));
        List<String> encryptedWords = new ArrayList();

        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            if (null == current || current.length() == 0) {
                encryptedWords.add(current);
            } else {
                String encryptedWord = "";
                for (int j = 0; j < current.length(); j++) {
                    encryptedWord += morseCodes.get(current.charAt(j) - 'a');
                }
                encryptedWords.add(encryptedWord);
            }
        }

        Set<String> encryptedWordSet = new HashSet<>();
        for (int m = 0; m < encryptedWords.size(); m++) {
            encryptedWordSet.add(encryptedWords.get(m));
        }

        return encryptedWordSet.size();
    }
}