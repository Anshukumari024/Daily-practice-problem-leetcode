class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];
        Arrays.sort(changed);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int[] ans = new int[n / 2];
        int idx = 0;
        for (int x : changed) {
            if (map.get(x) == 0) continue;

            int twice = x * 2;
            if (!map.containsKey(twice) || map.get(twice) == 0) {
                return new int[0];
            }
            if(idx<n/2)
            ans[idx++] = x;
            map.put(x, map.get(x) - 1);
            map.put(twice, map.get(twice) - 1);
        }

        return ans;
    }
}
