class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        boolean result = true;
        Map<Integer, Integer> frequency = new HashMap();

        for (int i = 0; i < target.length; i++) {
            frequency.put(target[i], frequency.getOrDefault(target[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (frequency.containsKey(arr[i]) && frequency.get(arr[i]) > 0) {
                frequency.put(arr[i], frequency.get(arr[i]) - 1);
            } else {
                result = false;
                break;
            }
        }

        return result;
    }
}