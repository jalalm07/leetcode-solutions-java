class Solution {
    public int majorityElement(int[] nums) {

        if(nums.length == 1) return nums[0];

        Map<Integer, Integer> countMap = new HashMap<>();
        int mark = nums.length / 2;
        for(int num : nums){
            if(countMap.containsKey(num)){
                if(countMap.get(num) + 1 > mark) return num;
                else countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            } else countMap.put(num, 1);
        }
        return -1;
    }
}