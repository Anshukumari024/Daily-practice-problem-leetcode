class Solution {
    public int minOperations(int n, int m) {
        if(Prime(n) || Prime(m)){
            return -1;
        }

        String start = String.valueOf(n);
        String target = String.valueOf(m);

        if (start.length() != target.length()) return -1;

        PriorityQueue<Pair> pq =new PriorityQueue<>((a, b) -> a.val - b.val);
      
        pq.add(new Pair(start, n));
        HashMap<String, Integer> vi = new HashMap<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.s.equals(target)) return p.val;

            if (vi.containsKey(p.s) && vi.get(p.s) <= p.val) continue;
            vi.put(p.s, p.val);

            for (int i = 0; i < p.s.length(); i++) {
                char[] arr = p.s.toCharArray();
                if (arr[i] < '9') {
                    arr[i]++;
                    String ns = new String(arr);
                    if (ns.charAt(0) != '0' && !Prime(Integer.parseInt(ns))) {
                        pq.add(new Pair(ns, p.val + Integer.parseInt(ns)));
                    }
                }

                arr = p.s.toCharArray();
                if (arr[i] > '0') {
                    arr[i]--;
                    String ns = new String(arr);
                    if (ns.charAt(0) != '0' && !Prime(Integer.parseInt(ns))) {
                        pq.add(new Pair(ns, p.val +Integer.parseInt(ns) ));
                    }
                }
            }
        }
        return -1;
    }

    public boolean Prime(int p) {
        if (p <= 1) return false;
        for (int i = 2; i * i <= p; i++) {
            if (p % i == 0) return false;
        }
        return true;
    }

    class Pair {
        String s;
        int val;
        Pair(String s, int val) {
            this.s = s;
            this.val = val;
        }
    }
}