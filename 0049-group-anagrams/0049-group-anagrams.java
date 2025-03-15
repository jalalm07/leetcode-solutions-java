class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            List<String> lnew = map.getOrDefault(sorted, new ArrayList<String>());
            lnew.add(s);
            map.put(sorted, lnew);
        }
        return new ArrayList<>(map.values());
    }
}