class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums.length == 0){
            return ans;
        }
        int startIndex = search(nums, target, true);
        int endIndex = search(nums, target, false);
        ans[0] = startIndex;
        ans[1] = endIndex;
        return ans;
    }

    int search(int[] nums, int target, boolean findFirstIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length;

        while(start <= end){
            int mid = (start + end) / 2;
            if (mid >= nums.length) return ans;
            if (target < nums[mid]) end = mid - 1;
            else if (target > nums[mid]) start = mid + 1;
            else {
                ans = mid;
                if (findFirstIndex) end = mid -1;
                else start = mid + 1;
            }
        }
        return ans;
    }
}