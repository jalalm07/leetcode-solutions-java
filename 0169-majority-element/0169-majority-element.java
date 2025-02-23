class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int majoritySize = nums.length / 2;
        for(int n : nums){
            if(map.containsKey(n)){
                if(map.get(n) >= majoritySize) return n;
            }
            map.put(n, map.getOrDefault(n , 0) + 1);
        }
        return -1;
    }
}