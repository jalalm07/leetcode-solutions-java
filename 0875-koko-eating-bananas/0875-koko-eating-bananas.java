class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int low = 0;
       int high = findMax(piles);
       while(low <= high){
            int mid = (low + high) / 2;
            int totalHours = findHours(piles, mid);
            if(totalHours <= h) high = mid - 1;
            else low = mid + 1;
       }
       return low;
    }

    private int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max)
                max = Math.max(max, piles[i]);
        }
        return max;
    }

    private int findHours(int[] piles, int hourly){
        int totalH = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return totalH;
    }
}