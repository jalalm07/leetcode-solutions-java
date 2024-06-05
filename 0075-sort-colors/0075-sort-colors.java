class Solution {
    public void sortColors(int[] nums) {
        int mid = 0;
        int high = nums.length - 1;
        int low =0;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                mid++;
                low++;
            } else if(nums[mid] == 1){
                mid++;
            } else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int low, int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}