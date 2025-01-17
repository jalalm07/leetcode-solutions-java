class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }
        fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast)
                return slow;
        }

        /*
         * int i = 0;
         * while(i < nums.length){
         * if(nums[i] != i+1){
         * int correctIndexOfi = nums[i] - 1;
         * if(nums[correctIndexOfi] != nums[i]){
         * int temp = nums[i];
         * nums[i] = nums[correctIndexOfi];
         * nums[correctIndexOfi] = temp;
         * } else return nums[i];
         * } else i++;
         * }
         * return -1;
         * 
         */
    }
}