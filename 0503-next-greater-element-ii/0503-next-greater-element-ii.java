class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];
        for(int i = 0; i < (nums.length *2) - 1; i++){
            while(!st.isEmpty() && st.peek() < nums[i % nums.length])
                map.put(st.pop(), nums[i % nums.length]);
            st.push(nums[i % nums.length]);
        }
        int index = 0;
        for(int num: nums){
            ans[index++] = map.getOrDefault(num, -1);
        }
        return ans;
    }
}