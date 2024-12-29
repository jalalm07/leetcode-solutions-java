class Solution {
    public boolean containsDuplicate(int[] nums) {
        //Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}