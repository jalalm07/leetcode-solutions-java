class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<mountain.length-1; i++){
            int prev = mountain[i-1];
            int curr = mountain[i];
            int next = mountain[i+1];

            if(prev < curr && curr > next)
            list.add(i);
        }

        return list;
    }
}