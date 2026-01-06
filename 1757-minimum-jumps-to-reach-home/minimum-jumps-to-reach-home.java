class Solution {

    class Pair {
        int pos;
        int dir; // 0 = forward, 1 = backward

        Pair(int pos, int dir) {
            this.pos = pos;
            this.dir = dir;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        HashSet<Integer> forbid = new HashSet<>();
        for (int f : forbidden) forbid.add(f);

        int max = x;
        for (int f : forbidden) max = Math.max(max, f);
        max += a +b;

        HashSet<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        visited.add("0-0");

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair cur = q.poll();
                int pos = cur.pos;
                int dir = cur.dir;

                if (pos == x) return steps;
                int forward = pos + a;
                if (forward <= max &&
                    !forbid.contains(forward) &&
                    visited.add(forward + "-0")) {
                    q.add(new Pair(forward, 0));
                }
                int backward = pos - b;
                if (dir == 0 &&
                    backward >= 0 &&
                    !forbid.contains(backward) &&
                    visited.add(backward + "-1")) {
                    q.add(new Pair(backward, 1));
                }
            }
            steps++;
        }

        return -1;
    }
}
