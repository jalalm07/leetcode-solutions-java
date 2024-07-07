class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int cnt = 0;
        int el2 = n / 2;
        int el1 = (n/2) - 1;
        int indexEl1 = -1;
        int indexEl2 = -2;

        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                if(cnt == el1) indexEl1 = nums1[i];
                if(cnt == el2) indexEl2 = nums1[i];
                cnt++;
                i++;
            } else {
                if(cnt == el1) indexEl1 = nums2[j];
                if(cnt == el2) indexEl2 = nums2[j];
                cnt++;
                j++;
            }
        }

        while(i < n1){
            if(cnt == el1) indexEl1 = nums1[i];
            if(cnt == el2) indexEl2 = nums1[i];
            cnt++;
            i++;
        }

        while(j < n2){
            if(cnt == el1) indexEl1 = nums2[j];
            if(cnt == el2) indexEl2 = nums2[j];
            cnt++;
            j++;
        }

        if(n%2 == 1) return indexEl2;
        else return ((double) (indexEl1 + indexEl2)) / 2.0;
    }
}