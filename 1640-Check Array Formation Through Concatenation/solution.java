class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }

        for (int i = 0; i < arr.length;) {
            if (map.containsKey(arr[i])) {
                int[] curr = pieces[map.get(arr[i])];
                for (int j = 0; j < curr.length; j++) {
                    if (arr[i] != curr[j]) {
                        return false;
                    } else {
                        i++;
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }
}