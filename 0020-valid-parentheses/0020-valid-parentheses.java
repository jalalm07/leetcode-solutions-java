class Solution {
    public boolean isValid(String s) {
        Stack<Character> chStack = new Stack<>();
        char[] chArr = s.toCharArray();
        for(char ch : chArr){
            if(ch == '(' || ch == '[' || ch == '{'){
                chStack.push(ch);
            }
            else if(ch == ')'){
                if(chStack.isEmpty() || chStack.pop() != '(') return false;
            }
            else if(ch == ']'){
                if(chStack.isEmpty() || chStack.pop() != '[') return false;
            }
            else if(ch == '}'){
                if(chStack.isEmpty() || chStack.pop() != '{') return false;
            }
        }
        return chStack.isEmpty();
    }
}