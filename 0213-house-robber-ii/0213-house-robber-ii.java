class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(f(Arrays.copyOfRange(nums, 0, n - 1)), f(Arrays.copyOfRange(nums, 1, n)));
    }

    private int f(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i < n; i++){
            int pick = nums[i] + prev2;
            int notPick = 0 + prev;
            int curri = Math.max(pick, notPick);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}