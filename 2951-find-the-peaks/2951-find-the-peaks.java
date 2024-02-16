class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<Integer>();
        if(mountain.length >= 3){
            if(mountain.length == 3){
                if(mountain[1] > mountain[0] && mountain[1] > mountain[2]){
                    result.add(1);
                }
            } else {
                for(int i=1; i < mountain.length-1; i++){
                    if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]){
                    result.add(i);
                }
                }
            }
        } else {
            return result;
        }
        return result;
    }
}