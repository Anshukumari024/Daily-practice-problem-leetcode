class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        unordered_set<string> set(nums.begin(),nums.end());
        return solve(nums[0].length(),"",set);
    }
    string solve(int n,string ans,unordered_set<string> &set){
        if(ans.length()==n){
            if(set.find(ans)==set.end()){
                return ans;
            }
            return "";
        }
        string l=solve(n,ans+"0",set);
        if(l != "") return l;
        return solve(n,ans+"1",set);
    }
};