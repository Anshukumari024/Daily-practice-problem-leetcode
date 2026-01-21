class Solution {
    public int minimizeXor(int num1, int num2) {
        int set=0;
        //find setbits of num2
        while(num2>0){
            num2=(num2&(num2-1));
            set++;
        }
        int xor=0;
        int x=0;
        //1 ke neeche 1
        for(int i=30;i>=0;i--){
            int mask=(1<<i);
            if((num1&mask)!=0){
                x|=mask;
                set--;
                if(set==0) return x;
            }
        }
        for(int i=0;i<=30;i++){
            int mask=(1<<i);
            if(((num1&mask)==0)){
                x|=mask;
                set--;
                if(set==0) return x;
            }
        }
        return -1;
        
    }
}