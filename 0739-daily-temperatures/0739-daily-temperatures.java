class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        // Stack<Integer> stack = new Stack<>();
        // for(int i =0; i < n; i++){
        //     while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ){
        //         ans[stack.peek()] = i - stack.pop();
        //     }
        //     stack.push(i);
        // }



        Stack<int[]> stack = new Stack<>();
        int i = 1;
        stack.push(new int[] {temperatures[0], 0});
        do{
            if(temperatures[i] < stack.peek()[0]){
                stack.push(new int[] {temperatures[i], i});
            }
            else{
                while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                    int[] node = stack.pop();
                    ans[node[1]] = i - node[1];
                }
                stack.push(new int[] {temperatures[i], i});
            }
            i++;
        }while(i < n);

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(temperatures[j] > temperatures[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}