class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i < weights.length; i++){
            high += weights[i];
            low = Math.max(low, weights[i]);
        } 
        while(low <= high){
            int mid = (low + high) / 2;
            int daysReq = noOfDaysRequired(weights, mid);
            if(daysReq <= days){
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }

    private int noOfDaysRequired(int[] weights, int cap){
       int days = 1;
       int load = 0;
       for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > cap){
                days += 1;
                load = weights[i];
            } else load += weights[i];
       }
       return days;
    }
}