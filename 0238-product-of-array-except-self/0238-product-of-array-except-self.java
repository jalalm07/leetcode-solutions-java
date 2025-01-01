class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] result = new int[n];
        int[] suffix = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0) prefix[i] = 1;
            else prefix[i] = prefix[i - 1] * nums[i -1];
        }
        
        for(int j = n - 1; j >= 0; j--){
            if(j == n - 1) suffix[j] = 1;
            else suffix[j] = suffix[j+1] * nums[j + 1];
        }
        for(int i = 0; i < n; i++){
            result[i] = prefix[i] * suffix[i];
        }
       
        return result;
    }
}