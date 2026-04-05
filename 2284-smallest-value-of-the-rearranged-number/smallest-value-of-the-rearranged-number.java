class Solution {
    public long smallestNumber(long num) {
        long ans=0;
        if(num<0){
            num=-num;
            List<Long> ll=new ArrayList<>();
            while(num>0){
                long rem=num%10; 
                ll.add(rem);
                num=num/10;
            }
            Collections.sort(ll,Collections.reverseOrder());
            if(ll.size()>2){
                if(ll.get(0)==0){
                    long n=ll.get(1);
                    ll.set(1,ll.get(0));
                    ll.set(0,n);
                }
            }
            for(int i=0;i<ll.size();i++){
                ans=ans*10+ll.get(i);
            }
            return -ans;
        }
        else{
            List<Long> ll=new ArrayList<>();
            while(num>0){
                long rem=num%10; 
                ll.add(rem);
                num=num/10;
            }
            Collections.sort(ll);
            if (ll.size() > 0 && ll.get(0) == 0) {
            for (int i = 1; i < ll.size(); i++) {
                if (ll.get(i) != 0) {
                    long temp = ll.get(i);
                    ll.set(i, 0L);
                    ll.set(0, temp);
                    break;
                }
            }
        }

            for(int i=0;i<ll.size();i++){
                ans=ans*10+ll.get(i);
            }
        }
       
        return ans;
    }
}