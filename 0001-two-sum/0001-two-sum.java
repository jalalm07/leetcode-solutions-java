class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int comple = target - nums[i];
            if(map.containsKey(comple)){
                return new int[] {map.get(comple), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[2];


        // int ans[] = new int[2];
        // for(int i = 0; i < nums.length - 1; i++){
        //     for(int j = i + 1; j < nums.length ; j++){
        //         if(nums[i] + nums[j] == target){
        //             ans[0] = i;
        //             ans[1] = j;
        //         }
        //     }
        // }
        // return ans;
    }
}