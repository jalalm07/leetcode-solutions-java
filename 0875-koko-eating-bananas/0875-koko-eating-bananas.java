class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int m = (l + r) / 2, total = 0;
            for (int p : piles)
                total += (p + m - 1) / m;
            if (total > h)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    private static int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int n: piles){
            if(n > max) max = n;
        }
        return max;
    }
}