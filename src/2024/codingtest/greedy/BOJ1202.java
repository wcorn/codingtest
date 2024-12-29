package codingtest.greedy;

import java.util.*;
import java.io.*;

public class BOJ1202 {
    private static int N;
    private static int K;
    private static List<Integer> bag;
    private static List<Jewel> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bag = new ArrayList<>();
        list = new ArrayList<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        Collections.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && list.get(j).M <= bag.get(i)) {
                pq.offer(list.get(j++).V);
            }
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }

    private static class Jewel implements Comparable<Jewel> {
        int M;
        int V;

        public Jewel(int M, int V) {
            this.M = M;
            this.V = V;
        }

        @Override
        public int compareTo(Jewel jewel) {
            if (this.M == jewel.M) {
                return jewel.V - this.V;
            }
            return this.M - jewel.M;
        }
    }
}
