public class Solution {
    public int[] constructRectangle(int area) {
        if (area == 0) return new int[2];
        int[] result = new int[2];
        for (int w = 1; w <= area; w++) {
            if (area % w != 0) continue;
            if (w <= area / w) {
                result[1] = w;
                result[0] = area / w;
            } else {
                break;
            }
        }

        return result;
    }
}