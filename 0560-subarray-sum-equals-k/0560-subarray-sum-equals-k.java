class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0,1);
        int count = 0;
        int preSum = 0;
        countMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            count += countMap.getOrDefault(remove, 0);
            countMap.put(preSum, countMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
}
}