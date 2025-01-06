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
/*
     public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for characters in `t`
        Map<Character, Integer> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        // Two pointers for sliding window
        int l = 0, r = 0;
        int required = countT.size(); // Number of unique characters in `t` to be matched
        int formed = 0; // Number of unique characters that are fully matched in current window
        Map<Character, Integer> countS = new HashMap<>();

        // Variables to track the minimum window
        int[] ans = {-1, 0, 0}; // {window length, left, right}

        while (r < s.length()) {
            // Add the current character to the window
            char c = s.charAt(r);
            countS.put(c, countS.getOrDefault(c, 0) + 1);

            // Check if this character matches the frequency in `t`
            if (countT.containsKey(c) && countS.get(c).intValue() == countT.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left
            while (l <= r && formed == required) {
                // Update the minimum window
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // Remove the leftmost character
                char leftChar = s.charAt(l);
                countS.put(leftChar, countS.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && countS.get(leftChar).intValue() < countT.get(leftChar).intValue()) {
                    formed--;
                }
                l++;
            }

            // Expand the window
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }*/
}