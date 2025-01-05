class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1char = s1.toCharArray();
        Arrays.sort(s1char);
        String newS1 = new String(s1char);
        for(int i = 0; i < s2.length(); i++){
            for(int j = i; j < s2.length(); j++){
                char[] strChar = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(strChar);
                String newStr = new String(strChar);
                if(newStr.equals(newS1)) return true;
            }
        }
        return false;
    }
}