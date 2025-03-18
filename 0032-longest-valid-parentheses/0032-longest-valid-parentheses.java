class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0; // Stores the maximum length of valid parentheses substring
        int left = 0, right = 0; // Counters for '(' and ')' while scanning

        // Step 1: Left to Right Scan
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++; // Count '('
            else
                right++; // Count ')'

            // If counts match, update max length
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            }
            // If more ')' than '(', reset counters
            else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0; // Reset counters for right-to-left scan

        // Step 2: Right to Left Scan
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                right++; // Count ')'
            else
                left++; // Count '('

            // If counts match, update max length
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            }
            // If more '(' than ')', reset counters
            else if (left > right) {
                left = right = 0;
            }
        }

        return maxLength; // Return the maximum length found
    }
}