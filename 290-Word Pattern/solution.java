public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;

        Map<Character, String> patternMap = new HashMap<Character, String>();
        Set<String> strSet = new HashSet<String>();
        for(int i=0; i<pattern.length(); i++){
            if(patternMap.get(pattern.charAt(i)) == null){
                if(strSet.contains(strs[i])) return false;
                patternMap.put(pattern.charAt(i), strs[i]);
                strSet.add(strs[i]);
            }else{
                if(!patternMap.get(pattern.charAt(i)).equals(strs[i])) return false;
            }
        }

        return true;
    }
}