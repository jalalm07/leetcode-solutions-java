class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            List<String> lnew = map.getOrDefault(sorted, new ArrayList<String>());
            lnew.add(s);
            map.put(sorted, lnew);
        }
        
        for(List<String> ls : map.values()){
            answer.add(ls);
        }
        return answer;
    }
}