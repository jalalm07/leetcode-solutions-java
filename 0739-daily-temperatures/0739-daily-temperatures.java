class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return res;



        // Stack<int[]> stack = new Stack<>();
        // int i = 1;
        // stack.push(new int[] {temperatures[0], 0});
        // do{
        //     if(temperatures[i] < stack.peek()[0]){
        //         stack.push(new int[] {temperatures[i], i});
        //     }
        //     else{
        //         while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
        //             int[] node = stack.pop();
        //             ans[node[1]] = i - node[1];
        //         }
        //         stack.push(new int[] {temperatures[i], i});
        //     }
        //     i++;
        // }while(i < n);

        // for(int i = 0; i < n - 1; i++){
        //     for(int j = i + 1; j < n; j++){
        //         if(temperatures[j] > temperatures[i]){
        //             ans[i] = j - i;
        //             break;
        //         }
        //     }
        // }
        //return ans;
    }
}