class Solution {
    public double maxAverageRatio(int[][] c, int e) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(
                ((b[0] + 1) / (b[1] + 1)) - (b[0] / b[1]),
                ((a[0] + 1) / (a[1] + 1)) - (a[0] / a[1]))
        );
        for (int i = 0; i < c.length; i++) {
            pq.add(new double[] { c[i][0], c[i][1] });
        }
        double r = 0;
        for (int i = 0; i < e; i++) {
            double[] t = pq.poll();
            pq.add(new double[] { t[0] + 1, t[1] + 1 });
        }
        for (double[] i : pq) {
            r += i[0] / i[1];
        }
        return r / c.length;
    }
}
