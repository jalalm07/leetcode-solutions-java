class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums[nums.length - 1];
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += n;
            n++; 
        }
        return sum;
    }
}