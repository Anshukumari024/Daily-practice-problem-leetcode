class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        int rc=0;
        int cc=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                   rc=0;
                   cc=0;
                    for(int r=0;r<mat[0].length;r++){
                        if(r==j) continue;
                        if(mat[i][r]==0) rc++;
                    }
                    for(int c=0;c<mat.length;c++){
                        if(c==i) continue;
                        if(mat[c][j]==0) cc++;
                    }
                    if((rc==mat[0].length-1 ) && (cc==mat.length-1)) count++;
                }
                
            }
        }
        return count;
        
    }
}