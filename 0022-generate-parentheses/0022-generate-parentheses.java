class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(0,0,result,n, new StringBuilder());
        return result;
    }

    private static void backtrack(int open, int close, List<String> result, int n, StringBuilder str){
        // base condition open == close == n
        if(open == close && open == n){
            result.add(str.toString());
            return;
        }

        // open < n , add ( and recursively call with open+1
        if(open < n){
            str.append("(");
            backtrack(open + 1, close, result, n, str);
            str.deleteCharAt(str.length() - 1);
        }

        // close < open, add ) and recursively call with close+1
        if(close < open){
            str.append(")");
            backtrack(open, close + 1, result, n, str);
            str.deleteCharAt(str.length() - 1);
        }

    }
}