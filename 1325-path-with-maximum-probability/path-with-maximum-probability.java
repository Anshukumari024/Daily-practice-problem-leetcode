class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            graph.get(u).add(new double[]{v, p});
            graph.get(v).add(new double[]{u, p});
        }
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        PriorityQueue<double[]> pq =new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int node = (int) cur[0];
            double prob = cur[1];

            if (node == end) return prob;

            for (double[] nei : graph.get(node)) {
                int next = (int) nei[0];
                double newProb = prob * nei[1];

                if (newProb > maxProb[next]) {
                    maxProb[next] = newProb;
                    pq.offer(new double[]{next, newProb});
                }
            }
        }

        return 0.0;
        
    }
}