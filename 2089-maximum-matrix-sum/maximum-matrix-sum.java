class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int c_n=0;
        long sum=0;
        int m_i=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0) c_n++;
                m_i=Math.min(m_i,Math.abs(matrix[i][j]));
                sum+=Math.abs(matrix[i][j]);
            }
        }
        if(c_n%2 !=0){
            sum=sum-(2*m_i);
        }
        return sum;
        
    }
}