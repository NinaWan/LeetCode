class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, List<String>> map = new HashMap() {
            {
                put('2', Arrays.asList("a", "b", "c"));
                put('3', Arrays.asList("d", "e", "f"));
                put('4', Arrays.asList("g", "h", "i"));
                put('5', Arrays.asList("j", "k", "l"));
                put('6', Arrays.asList("m", "n", "o"));
                put('7', Arrays.asList("p", "q", "r", "s"));
                put('8', Arrays.asList("t", "u", "v"));
                put('9', Arrays.asList("w", "x", "y", "z"));
            }
        };

        dfs(result, digits.toCharArray(), 0, "", map);

        return result;
    }

    private void dfs(List<String> result, char[] digits, int start, String temp, Map<Character, List<String>> map) {
        if (start == digits.length) {
            result.add(temp);
            return;
        }

        List<String> chars = map.get(digits[start]);
        for (int i = 0; i < chars.size(); i++) {
            temp += chars.get(i);
            dfs(result, digits, start + 1, temp, map);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}