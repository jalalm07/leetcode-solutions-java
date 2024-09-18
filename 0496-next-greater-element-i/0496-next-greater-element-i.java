class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        //int[] ans = new int[nums1.length];
        for(int i = 0; i < nums2.length;  i++){
            while(!st.isEmpty() && st.peek() < nums2[i])
                map.put(st.pop(), nums2[i]);
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}