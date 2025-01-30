class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, 0, target, subset);
        return result;
    }

    private void dfs(int[] nums, int i, int target, List<Integer> subset){
    if(i >= nums.length || target < 0){
        return;
    }
    if(target == 0){
        result.add(new ArrayList<>(subset));
        return;
    }

    subset.add(nums[i]);
    dfs(nums, i, target - nums[i], subset);
    subset.remove(subset.size() - 1);

    dfs(nums, i + 1, target, subset);
}
}

