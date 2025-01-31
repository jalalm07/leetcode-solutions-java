class Solution {
        public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        dfs(s, subset, result, 0);
        return result;
    }

    private void dfs(String s, List<String> subset, List<List<String>> result, int i){
        if(i >= s.length()){
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPalin(s, i, j)){
                subset.add(s.substring(i ,j + 1));
                dfs(s, subset, result, j + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private boolean isPalin(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}