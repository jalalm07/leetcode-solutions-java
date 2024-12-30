class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s = strs[0];
        String t = strs[strs.length - 1];
        int n = Math.min(s.length(), t.length());
        String prefix = s;
        int i;
        for(i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                break;
            }
        }
        return s.substring(0, i);
    }
}