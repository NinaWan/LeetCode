public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0 && t.length() == 0) return true;
        Map sMap = new HashMap<Character, Integer>();
        Map tMap = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            if(sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), (int)sMap.get(s.charAt(i))+1);
            }else{
                sMap.put(s.charAt(i), 1);
            }

            if(tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), (int)tMap.get(t.charAt(i))+1);
            }else{
                tMap.put(t.charAt(i), 1);
            }
        }
        Iterator sIterator = sMap.keySet().iterator();
        while(sIterator.hasNext()){
            char key = (char)sIterator.next();
            if(!tMap.containsKey(key)) return false;
            if((int)sMap.get(key) != (int)tMap.get(key)){
                return false;
            }
        }
        return true;
    }
}