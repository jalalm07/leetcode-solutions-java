class Solution {
    int resLen = 0;
    int resIdx = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            isPalin(s, i, i);
            isPalin(s, i, i+1);
        }
        return s.substring(resIdx, resIdx + resLen);
    }

    private void isPalin(String s, int l , int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    resIdx = l;
                }
                l--;
                r++;
        }
    }
}