class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        int i = 0;
        while(i < nums.length){
            int correctIndexOfi = nums[i];
            if(correctIndexOfi != i && correctIndexOfi < nums.length){
                int temp = nums[i];
                nums[i] = nums[correctIndexOfi];
                nums[correctIndexOfi] = temp;
            } else {
                i++;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j)
                return j;
        }
        return ans;
    }
}