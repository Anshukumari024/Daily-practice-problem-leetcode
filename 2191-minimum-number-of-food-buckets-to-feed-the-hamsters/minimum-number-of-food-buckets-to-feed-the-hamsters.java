class Solution {
    public int minimumBuckets(String hamsters) {
        char[] arr=hamsters.toCharArray();
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='H'){
                if((i>0 && arr[i-1]=='@') || (i<arr.length-1 && arr[i+1]=='@')){
                    continue;
                }
                if((i>0 && arr[i-1]=='.') || (i<arr.length-1 && arr[i+1]=='.')){
                    if(i<arr.length-1 && arr[i+1]=='.') {
                        arr[i+1]='@';
                        c++;
                    }
                    else if(i==arr.length-1) {
                        arr[i-1]='@';
                        c++;
                    }
                    else if(i>0 && arr[i-1]=='.'){
                        arr[i-1]='@';
                        c++;
                    }
                }
                else return -1;
            }
        }
        return c;
        
    }
}