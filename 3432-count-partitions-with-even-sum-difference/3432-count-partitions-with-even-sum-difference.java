class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int tempSum = 0;
        for(int i = 0; i < nums.length -1; i++){
            tempSum += nums[i]; 
            if(Math.abs(tempSum + (sum - tempSum)) % 2 == 0) count++;
        }
        return count;
    }
}