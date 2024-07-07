class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for(int n : nums){
                max = Math.max(max, n);
                sum += n;
        }
        int start = max;
        int end = sum;
        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(canSplit(mid, nums, k)){
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    boolean canSplit(int largest, int[] nums, int k){
        int subArray = 0;
        int currSum = 0;

        for(int n : nums){
            currSum += n;
            if(currSum > largest){
                subArray += 1;
                currSum = n;
            }
        }
        return subArray + 1 <= k;
    }
}