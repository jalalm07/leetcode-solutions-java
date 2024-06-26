class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (nums[mid] == target)
                return mid;

            // if left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end -start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            } 
            if (mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            } 
            if (nums[mid] <= nums[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int binarySearch(int[] nums, int start, int end, int target){
        while (start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            } else if (target > nums[mid]){
                 start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}