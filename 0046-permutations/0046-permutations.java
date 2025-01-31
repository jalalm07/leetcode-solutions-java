class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        dfs(nums,result,subset, pick);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, boolean[] pick){
        if(subset.size() == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                subset.add(nums[i]);
                pick[i] = true;
                dfs(nums, result, subset, pick);
                subset.remove(subset.size() - 1);
                pick[i] = false;
            }
        }
    }
}