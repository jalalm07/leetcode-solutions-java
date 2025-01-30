class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,result,subset);
        return result;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> result, List<Integer> subset){
        if(i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[i]);
        dfs(nums, i+1, result, subset);
        subset.remove(subset.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        dfs(nums, i+1, result, subset);
    }
}