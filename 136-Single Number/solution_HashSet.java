import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        Set result = new HashSet<Integer>();
        for (int num : nums) {
            if (result.contains(num)) {
                result.remove(num);
            } else {
                result.add(num);
            }
        }
        for(Object single:result){
            return (Integer) single;
        }
        return Integer.MIN_VALUE;
    }
}