class Quadruplet {
    int num1;
    int num2;
    int num3;
    int num4;

    public Quadruplet(int num1, int num2, int num3, int num4) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
    }

    @Override
    public int hashCode() {
        int result = num1;
        result = 31 * result + num2;
        result = 31 * result + num3;
        result = 31 * result + num4;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Quadruplet) {
            if (obj == this) {
                return true;
            }
            Quadruplet qObj = (Quadruplet) obj;

            return this.num1 == qObj.num1 && this.num2 == qObj.num2 && this.num3 == qObj.num3 && this.num4 == qObj.num4;
        }
        return false;
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                List<List<Integer>> ts = twoSum(nums, target - nums[i] - nums[j], j + 1, nums.length - 1);
                if (!ts.isEmpty()) {
                    for (List<Integer> l : ts) {
                        List<Integer> quadruplet = new ArrayList();
                        quadruplet.addAll(Arrays.asList(nums[i], nums[j]));
                        quadruplet.addAll(l);
                        result.add(quadruplet);
                    }
                    ;
                }
            }
        }

        return dedup(result);
    }

    public List<List<Integer>> dedup(List<List<Integer>> origin) {
        Set<Quadruplet> qSet = new HashSet();
        origin.stream()
                .map(list -> new Quadruplet(list.get(0), list.get(1), list.get(2), list.get(3)))
                .collect(Collectors.toList()).forEach(q -> qSet.add(q));
        return qSet.stream()
                .map(q -> new ArrayList<Integer>() {{
                    add(q.num1);
                    add(q.num2);
                    add(q.num3);
                    add(q.num4);
                }})
                .collect(Collectors.toList());
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> result = new ArrayList();
        for (int i = start, j = end; i < j; ) {
            if (nums[i] + nums[j] == target) {
                result.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            }
            if (nums[i] + nums[j] < target) {
                i++;
            }
            if (nums[i] + nums[j] > target) {
                j--;
            }
        }
        return result;
    }
}