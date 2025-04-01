class Solution {

        public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    // Helper method to perform backtracking
    private void backtrack(String s, int start, List<String> parts, List<String> result) {
        // Base case: if we have 4 parts and reached the end of string, it’s a valid IP
        if (parts.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        // Try 1 to 3 digit segments
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break; // Out of bounds

            String segment = s.substring(start, start + len);

            // Validate the segment
            if (isValid(segment)) {
                parts.add(segment); // Choose
                backtrack(s, start + len, parts, result); // Explore
                parts.remove(parts.size() - 1); // Un-choose
            }
        }
    }

    // Checks if a string segment is a valid IP part
    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false; // Leading zero
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }
}