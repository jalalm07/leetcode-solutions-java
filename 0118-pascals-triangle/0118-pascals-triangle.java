class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i<= numRows; i++){
            int ansTemp = 1;
             List<Integer> ansRow = new ArrayList<Integer>();
             ansRow.add(1);
             for(int j = 1; j < i; j++){
                ansTemp = ansTemp * (i - j);
                ansTemp = ansTemp / j;
                ansRow.add(ansTemp);
             }
             ans.add(ansRow);
        }
        return ans;
    }
}