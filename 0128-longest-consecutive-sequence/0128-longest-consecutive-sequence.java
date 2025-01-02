class Solution {
    public int longestConsecutive(int[] nums) {
           int max = 1;
        if(nums.length == 0) return 0;   
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
     
        for(int n: set){
            if(!set.contains(n - 1)){
                int nn = n;
                int count = 1;
                while(set.contains(nn+1)){
                    count++;
                    nn++;
                   
                }
                 max = Math.max(max, count);
            }
        }
        return max;
    }
}