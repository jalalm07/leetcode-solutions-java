class Solution {
    public void setZeroes(int[][] matrix) {

        int[] column = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    column[j] = 1;
                }  
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        for(int j = column.length - 1; j >= 0; j--){
            for(int i = 0; i < matrix.length; i++){
                if(column[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}