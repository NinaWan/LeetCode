class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] temp = new int[1001];

        for (int i = 0; i < arr1.length; i++) {
            temp[arr1[i]]++;
        }

        int index = 0;

        for (int j = 0; j < arr2.length; j++) {
            int current = arr2[j];
            while (temp[current] > 0) {
                result[index] = current;
                temp[current]--;
                index++;
            }
        }

        for (int m = 0; m < temp.length; m++) {
            while (temp[m] > 0) {
                result[index] = m;
                temp[m]--;
                index++;
            }
        }

        return result;
    }
}