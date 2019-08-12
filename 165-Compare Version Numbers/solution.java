public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");

        if (version1s.length < version2s.length) {
            String[] newVersion1s = initializeStringArray(version2s.length);
            populateStringArray(newVersion1s, version1s);
            return compareVersionWithSameLength(newVersion1s, version2s);
        } else {
            if (version1s.length > version2s.length) {
                String[] newVersion2s = initializeStringArray(version1s.length);
                populateStringArray(newVersion2s, version2s);
                return compareVersionWithSameLength(version1s, newVersion2s);
            } else {
                return compareVersionWithSameLength(version1s, version2s);
            }
        }
    }

    private String[] initializeStringArray(int length) {
        String[] sa = new String[length];
        for (int i = 0; i < length; i++) {
            sa[i] = "0";
        }
        return sa;
    }

    private void populateStringArray(String[] newStringArray, String[] existingStringArray) {
        if (newStringArray.length < existingStringArray.length) {
            return;
        } else {
            for (int i = 0; i < existingStringArray.length; i++) {
                newStringArray[i] = existingStringArray[i];
            }
        }
    }

    private int compareVersionWithSameLength(String[] version1, String[] version2) {
        if (version1.length != version2.length) return -2;
        for (int i = 0; i < version1.length; i++) {
            if (Integer.parseInt(version1[i]) > Integer.parseInt(version2[i])) {
                return 1;
            }
            if (Integer.parseInt(version1[i]) < Integer.parseInt(version2[i])) {
                return -1;
            }
        }
        return 0;
    }
}