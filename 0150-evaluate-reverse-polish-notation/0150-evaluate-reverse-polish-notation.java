class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        String operators ="+-*/";
        int result = 0;
        for(String str : tokens){
            if(operators.contains(str)){
                int n1 = st.pop();
                int n2 = st.pop();
                if(str.equals("+")){
                    result = n2 + n1;
                } else if(str.equals("-")){
                    result = n2 - n1;
                } else if(str.equals("*")){
                    result = n2 * n1;
                } else if(str.equals("/")){
                    result = n2 / n1;
                }
                st.push(result);
            } else {
                int number = Integer.parseInt(str);
                st.push(number);
            }
        }
        return st.isEmpty() ? result : st.pop();
    }
}