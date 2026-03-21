class Solution {
    public void solve(char[][] board) {
        int i=0;
        int j=0;
        int[][] vi=new int[board.length][board[0].length];
        for(i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                if(vi[i][0] != 1)
                    dfs(board,i,0,vi);
            }
        }
        for(i=board.length-1;i>=0;i--){
            if(board[i][board[0].length-1]=='O'){
                if(vi[i][board[0].length-1] != 1)
                    dfs(board,i,board[0].length-1,vi);
            }
        }
         for(j=0;j<board[0].length;j++){
            if(board[0][j]=='O'){
                if(vi[0][j] != 1)
                    dfs(board,0,j,vi);
            }
        }
        for(j=board[0].length-1;j>=0;j--){
            if(board[board.length-1][j]=='O'){
                if(vi[board.length-1][j] != 1)
                    dfs(board,board.length-1,j,vi);
            }
        }
        
        for(int k=0;k<vi.length;k++){
            for(int m=0;m<vi[0].length;m++){
                if(vi[k][m]==0 && board[k][m]=='O') board[k][m]='X';
            }
        }
    }
    public void dfs(char[][] board,int i,int j,int[][] vi){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        if(board[i][j]=='X' || vi[i][j]==1) return;
        vi[i][j]=1;
        dfs(board,i+1,j,vi);
        dfs(board,i,j+1,vi);
        dfs(board,i-1,j,vi);
        dfs(board,i,j-1,vi);
    }
}