public class Solution {
    public boolean checkRecord(String s) {
        if (null == s)
            return true;

        char[] records = s.toCharArray();
        int numA = 0;
        int numL = 0;
        for (char record : records) {
            if (record == 'A') {
                if (numA > 0)
                    return false;
                numA++;
            }

            if (record == 'L') {
                if (numL > 1)
                    return false;
                numL++;
            }

            if (record != 'L')
                numL = 0;
        }

        return true;
    }
}