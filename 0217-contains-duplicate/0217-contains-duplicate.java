class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet();
        for(int num : nums){
            if(hashset.contains(num))
                return true;
            else
                hashset.add(num);    
        }
        return false;
    }
}