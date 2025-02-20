class Solution {
    StringBuilder sb = new StringBuilder();
    Set<String> set = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        for(String s: nums){
            set.add(s);
        }
        dfs(nums);
        return sb.toString();
    }

    private boolean dfs(String[] nums){
        if(sb.length() == nums.length){
            if(!set.contains(sb.toString())){
                return true;
            }
            return false;
        }

        sb.append("0");
        if(dfs(nums) == true) return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        if(dfs(nums) == true) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
}