class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        if(n == 0) return;
        for(int i = m; i < n + m; i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}