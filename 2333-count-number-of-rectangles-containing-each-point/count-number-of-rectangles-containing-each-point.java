class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {

        List<Integer>[] buckets = new ArrayList[101];
        for (int i = 1; i <= 100; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int[] r : rectangles) {
            buckets[r[1]].add(r[0]);
        }
        for (int i = 1; i <= 100; i++) {
            Collections.sort(buckets[i]);
        }

        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int count = 0;
            for (int h = y; h <= 100; h++) {
                List<Integer> list = buckets[h];
                if (list.isEmpty()) continue;
                int idx = Collections.binarySearch(list, x);
                if (idx < 0) idx = -idx - 1;

                count += list.size() - idx;
            }

            result[i] = count;
        }

        return result;
    }
}
