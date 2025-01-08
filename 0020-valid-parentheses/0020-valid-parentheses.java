class Solution {
    public boolean isValid(String s) {
        
        char[] cache = new char[s.length()];
        int pt = 0;
        for (char c : s.toCharArray()) {
            if (c=='(') cache[pt++] = ')';
            else if (c=='{') cache[pt++] = '}';
            else if (c=='[') cache[pt++] = ']';
            else {
                if (pt == 0 || cache[--pt] != c) return false;
            }
        }
        return pt == 0;

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