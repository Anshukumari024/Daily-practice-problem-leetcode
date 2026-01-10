class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> fullLakeDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; 
            } else {
                int lake = rains[i];
                if (fullLakeDay.containsKey(lake)) {
                    int lastFilledDay = fullLakeDay.get(lake);
                    Integer dryDay = dryDays.ceiling(lastFilledDay);
                    if (dryDay == null) {
                        return new int[0]; 
                    }
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                fullLakeDay.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}
