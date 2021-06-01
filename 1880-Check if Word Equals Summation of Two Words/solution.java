class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNumericalValue(firstWord) + toNumericalValue(secondWord) == toNumericalValue(targetWord);
    }

    private int toNumericalValue(String s) {
        String res = "";
        for (char c : s.toCharArray()) {
            res += c - 'a';
        }
        return Integer.valueOf(res);
    }
}