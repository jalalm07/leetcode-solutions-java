class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        if(n == 1)
            return;

        for(int i = n -2; i >=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(nums, 0, n-1);
            return;
        }
            
        for(int i = n -1; i > index; i--){
            if(nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index+1, n-1);

    }

    private static void reverse(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}