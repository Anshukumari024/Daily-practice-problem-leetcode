class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int val=image[sr][sc];
        if(val==color) return image;
        dfs(image,sr,sc,val,color);
        return image;
    }
    public void dfs(int[][] image,int r,int c,int val,int color){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length) return;
        if(image[r][c]==val){
            image[r][c]=color;
            dfs(image,r+1,c,val,color);
            dfs(image,r,c+1,val,color);
            dfs(image,r-1,c,val,color);
            dfs(image,r,c-1,val,color);
        }
       
    }
}