class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int n: nums){
            if(mp.containsKey(n)) return true;
            mp.put(n, n);
        }
        return false;
    }
}