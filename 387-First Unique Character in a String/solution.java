public class Solution {
    public int firstUniqChar(String s) {
        if(null == s || s.isEmpty()) return -1;

        Map<Character, Integer> letterFreq = new LinkedHashMap();
        char letter = '0';

        for(int i=0; i<s.length(); i++){
            letterFreq.put(s.charAt(i), letterFreq.getOrDefault(s.charAt(i), 0)+1);
        }

        Iterator iterator = letterFreq.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> current = (Map.Entry<Character, Integer>)iterator.next();
            if(current.getValue() == 1){
                letter = current.getKey();
                break;
            }
        }

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == letter) return i;
        }
        return -1;
    }
}