class Solution {
    public boolean isValid(String s) {
        
       Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
            } else if((ch == '}' || ch == ']' || ch == ')') && stack.isEmpty()) return false;
            else if(ch == '}' && stack.pop() != '{'){
                return false;
            } else if(ch == ']' && stack.pop() != '['){
                return false;
            } else if(ch == ')' && stack.pop() != '('){
                return false;
            } 
        }
        return stack.isEmpty();

        /*Stack<Character> chStack = new Stack<>();
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
        */

    }
}