class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxOnes = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                if(count > maxOnes)
                    maxOnes = count;
            } else count = 0;
        }
        return maxOnes;
    }
}