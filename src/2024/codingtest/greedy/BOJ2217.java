package codingtest.greedy;

import java.util.*;
import java.io.*;

public class BOJ2217 {
    private static int N;
    private static PriorityQueue<Integer> pq;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>(Collections.reverseOrder());
        ans = 0;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        solve();
        System.out.println(ans);
    }

    private static void solve() {
        int now;
        int cnt = 0;
        while (!pq.isEmpty()) {
            now = pq.remove();
            cnt++;
            ans = Math.max(ans, now * cnt);
        }
    }
}
