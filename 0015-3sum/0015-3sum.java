class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int lastI, lastJ, lastK = 0;
        int k = nums.length - 1;
        List ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            lastI = nums[i];
            int j = i + 1;
            while (j < k) {
                lastJ = nums[j];
                lastK = nums[k];
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    while (j < k && nums[j] == lastJ) {
                        j++;
                    }
                    while (j < k && nums[k] == lastK) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else
                    k--;
            }
        }
        return ans;
    }
}