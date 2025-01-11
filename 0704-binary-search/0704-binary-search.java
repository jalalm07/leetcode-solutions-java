class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int l = 0;
        int r = nums.length -1;
        int mid = 0;

        while(l <= r){
            mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]){
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}