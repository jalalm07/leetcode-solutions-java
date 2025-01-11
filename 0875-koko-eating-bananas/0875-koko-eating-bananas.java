class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        int ans = Integer.MAX_VALUE;
        while(l <= r){
            int mid = (l + r) / 2;
            double sum = 0;
            for(int i = 0; i < piles.length; i++){
                sum += Math.ceil((double)piles[i] / mid);
            }
            if(sum > h){
                l = mid + 1;
            } else if(sum <= h){
                ans = (int)mid;
                r = mid  - 1;
            } 
        }
        return ans;
    }
}