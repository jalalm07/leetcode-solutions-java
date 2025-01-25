class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        PriorityQueue<int[]> minH = new PriorityQueue<>((a,b) -> (a[1]==b[1]) ? a[0]-b[0] : a[1]-b[1]);
        //PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int i = 0; i < points.length; i++){
            int[] arr = points[i];
            int xC = arr[0];
            int yC = arr[1];
            if(xC == x || yC == y){
                int dist = ((x-xC) * (x-xC)) + ((y-yC)*(y-yC));
                minH.add(new int[]{i, dist});
            }
        }

        if(minH.isEmpty()) return -1;
        return minH.peek()[0];
    }
}