class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int index = 1;
        for(Map.Entry entry: map.entrySet()){
            if(entry.getValue().equals(1)){
                if(index == k)
                    return (String) entry.getKey();
                else index++;    
            }
        }
        return "";
    }
}