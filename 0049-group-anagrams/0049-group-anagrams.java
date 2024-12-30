class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        if(strs.length == 1) {
            List<String> ls = new ArrayList<String>();
            ls.add(strs[0]);
            answer.add(ls);
            return answer;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(map.containsKey(sorted)){
                List<String> lnew = map.get(sorted);
                lnew.add(s);
                map.put(sorted, lnew);
            } else{
                List<String> lnew = new ArrayList<>();
                lnew.add(s);
                map.put(sorted, lnew);
            }
        }
        for(List<String> ls : map.values()){
            answer.add(ls);
        }
        return answer;
    }
}