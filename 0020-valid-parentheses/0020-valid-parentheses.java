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
    }
}