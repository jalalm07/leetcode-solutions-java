class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int[][] ans = image;
        fill(ans, sr, sc, image[sr][sc], color);
        return ans;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int newColor){
        if(sr >= 0 && sr < image.length &&  sc >= 0 && sc < image[0].length && image[sr][sc] == color){
            image[sr][sc] = newColor;
            fill(image, sr, sc - 1, color, newColor);
            fill(image, sr - 1, sc, color, newColor);
            fill(image, sr, sc + 1, color, newColor);
            fill(image, sr + 1, sc, color, newColor);
        }
    }
}