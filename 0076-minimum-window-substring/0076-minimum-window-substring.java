class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> countS = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = t.length() -1;
        int[] ansIndex = new int[2];
        String ans = "";
        int minWindow = Integer.MAX_VALUE;

        while(r < s.length() && l <= s.length() - t.length()){
            if(matches(countT, countS)){
                if(r - l + 1 < minWindow){
                    minWindow = r - l + 1;
                    //ans = s.substring(l, r + 1);
                    ansIndex[0] = l;
                    ansIndex[1] = r + 1;
                }
                countS.put(s.charAt(l), countS.get(s.charAt(l)) - 1);
                l++;
            } else {
                r++;
                if(r < s.length())
                countS.put(s.charAt(r), countS.getOrDefault(s.charAt(r),0) + 1);
            }
        }
        return s.substring(ansIndex[0], ansIndex[1]);
    }

    private static boolean matches(Map<Character, Integer> countT, Map<Character, Integer> countS){
        for(Character c : countT.keySet()){
            if(countS.containsKey(c)){
                if(countS.get(c) < countT.get(c)){
                    return false;
                }
            } else return false;
        }
         return true;
    }
}