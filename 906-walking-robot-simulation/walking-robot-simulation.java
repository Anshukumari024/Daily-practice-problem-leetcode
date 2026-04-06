class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set=new HashSet<>();
        for(int[] o:obstacles){
            int f=o[0];
            int s=o[1];
            set.add(f+"_"+s);
        }
        int x=0;
        int y=0;
        int md=0;
        int[] dir=new int[]{0,1};  
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-2){
                dir=new int[]{-dir[1],dir[0]};
            }
            else if(commands[i]==-1){
                dir=new int[]{dir[1],-dir[0]};
            }
            else{
                for(int j=0;j<commands[i];j++){
                    int nx=dir[0]+x;
                    int ny=dir[1]+y;
                    String str=nx+"_"+ny;
                    if(set.contains(str)){
                        break;
                    }
                    x=nx;
                    y=ny;
                }
            }
            md=Math.max(md,x*x+y*y);
        }    
        return md;
    }
}