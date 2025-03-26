class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l = 0;
        int r = 0;
        int l1 = word1.length();
        int l2 = word2.length();
        String mergedString = "";
        while(l < l1 && r < l2){
            mergedString += word1.charAt(l++);
            mergedString += word2.charAt(r++);
        }
        while(l < l1){
            mergedString += word1.charAt(l++);
        }
        while(r < l2){
            mergedString += word2.charAt(r++);
        }
        return mergedString;
    }
}