public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        String current = String.valueOf(n);
        Set<Integer> existingNum = new HashSet<Integer>();
        while (true) {
            int newNum = 0;
            for (int i = 0; i < current.length(); i++) {
                newNum += Math.pow(current.charAt(i) - 48, 2);
            }
            if (newNum == 1)
                return true;
            if (existingNum.contains(newNum))
                return false;
            existingNum.add(newNum);
            current = String.valueOf(newNum);
        }
    }
}