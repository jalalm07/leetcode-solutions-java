class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet();
        for(int num : nums){
            if(!hashset.add(num))
                return true;    
        }
        return false;
    }
}