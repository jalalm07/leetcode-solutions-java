class Solution {
    public int numberOfChild(int n, int k) {
        int mul = 1;
        int count = 0;
        for(int i = 0; i < k; i++){
            count = count + mul;
            if(count == n -1 || count == 0){
                mul *= -1;
            } 
        }
        return count ;
    }
}