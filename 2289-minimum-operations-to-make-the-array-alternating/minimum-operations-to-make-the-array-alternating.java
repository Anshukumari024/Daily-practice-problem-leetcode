class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> evenMap = new HashMap<>();
        Map<Integer, Integer> oddMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);
            else
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
        }
        
        int[] even = getTopTwo(evenMap);
        int[] odd  = getTopTwo(oddMap);
        
        if (even[0] != odd[0]) {
            return n - (even[1] + odd[1]);
        } else {
            int option1 = even[3] + odd[1];
            int option2 = even[1] + odd[3];
            return n - Math.max(option1, option2);
        }
    }
    public int[] getTopTwo(Map<Integer, Integer> map) {
        int val1 = -1, freq1 = 0;
        int val2 = -1, freq2 = 0;
        
        for (int key : map.keySet()) {
            int f = map.get(key);
            if (f > freq1) {
                val2 = val1; freq2 = freq1;
                val1 = key;  freq1 = f;
            } else if (f > freq2) {
                val2 = key;  freq2 = f;
            }
        }
        return new int[]{val1, freq1, val2, freq2};
    }
}
