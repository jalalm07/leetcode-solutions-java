class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int ans = 0;
        while(l < r){
            if(maxL <= maxR){
                  l++;
                if(maxL - height[l] > 0){
                    ans += maxL - height[l];
                }
                maxL = Math.max(maxL, height[l]);
              
            } else {
                    r--;
                if(maxR - height[r] > 0){
                    ans += maxR - height[r];
                }
                maxR = Math.max(maxR, height[r]);
            
            }
        }
        return ans;
    }
}