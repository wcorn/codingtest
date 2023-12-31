package codingtest.search;

import java.util.*;
import java.io.*;

public class BOJ12851 {
    private static int[] check;
    private static int N;
    private static int K;
    private static int count;
    private static int minTime = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new int[100_001];
        if (N >= K) {
            System.out.print((N - K) + "\n1");
            return;
        }
        bfs();
        System.out.print(minTime+"\n"+count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        check[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (minTime < check[now]) return;
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now + 1;
                else if (i == 1) next = now - 1;
                else next = now * 2;
                if (next < 0 || next > 100_000) continue;
                if (next == K) {
                    minTime = check[now];
                    count++;
                }
                if (check[next] == 0 || check[next] == check[now] + 1) {
                    q.add(next);
                    check[next] = check[now] + 1;
                }
            }
        }
    }
}