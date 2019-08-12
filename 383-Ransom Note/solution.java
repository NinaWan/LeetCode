public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letterFreq = new HashMap();
        for (int i = 0; i < magazine.length(); i++) {
            letterFreq.put(magazine.charAt(i), letterFreq.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            if (!letterFreq.containsKey(ransomNote.charAt(j))) return false;
            if (letterFreq.get(ransomNote.charAt(j)) == 0) return false;
            letterFreq.put(ransomNote.charAt(j), letterFreq.get(ransomNote.charAt(j)) - 1);
        }

        return true;
    }
}