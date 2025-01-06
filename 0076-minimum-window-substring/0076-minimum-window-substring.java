class Solution {
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
    }
}
