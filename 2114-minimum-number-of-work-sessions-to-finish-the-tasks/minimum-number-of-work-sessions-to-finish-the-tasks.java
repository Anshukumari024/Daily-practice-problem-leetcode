class Solution {
    int ans;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        reverse(tasks); 
        ans = tasks.length; 
        int[] sessions = new int[tasks.length];
        solve(tasks, 0, sessions, 0, sessionTime);
        return ans;
    }

    public void solve(int[] tasks, int idx, int[] sessions,
                           int c, int sessionTime) {

        if (c>=ans) return;
        if (idx==tasks.length) {
            ans=Math.min(ans,c);
            return;
        }
        for (int i = 0; i <c; i++) {
            if (sessions[i]+tasks[idx]<=sessionTime) {
                sessions[i]+=tasks[idx];
                solve(tasks,idx+1,sessions,c,sessionTime);
                sessions[i]-=tasks[idx];
            }
        }
        sessions[c]=tasks[idx];
        solve(tasks,idx+1,sessions,c+1,sessionTime);
        sessions[c] = 0;
    }

    public void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
