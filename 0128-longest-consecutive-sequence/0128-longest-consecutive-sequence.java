class Solution {
    public int longestConsecutive(int[] nums) {


        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int lastSmall = Integer.MIN_VALUE;
        int longestSeq = 1;
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 == lastSmall){
                count++;
                 lastSmall = nums[i];
            } else if(nums[i] != lastSmall){
                count = 1;
                lastSmall = nums[i];
            }
           
            longestSeq = Math.max(longestSeq, count);
        }

        return longestSeq;
    }
}