class Solution {
    public int countCharacters(String[] words, String chars) {
        if (null == words || words.length == 0 || chars.length() == 0) {
            return 0;
        }

        int result = 0;
        Map<Character, Integer> frequenceC = new HashMap<>();

        for (int i = 0; i < chars.length(); i++) {
            Character current = chars.charAt(i);
            frequenceC.put(current, frequenceC.getOrDefault(current, 0) + 1);
        }

        for (int m = 0; m < words.length; m++) {
            Map<Character, Integer> frequenceW = new HashMap<>();
            for (int n = 0; n < words[m].length(); n++) {
                Character current = words[m].charAt(n);
                frequenceW.put(current, frequenceW.getOrDefault(current, 0) + 1);
            }

            boolean flag = true;
            for (Map.Entry current : frequenceW.entrySet()) {
                int countW = frequenceW.get(current.getKey());
                if (frequenceC.containsKey(current.getKey())) {
                    int countC = frequenceC.get(current.getKey());
                    if (countC < countW) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result += words[m].length();
            }
        }

        return result;
    }
}