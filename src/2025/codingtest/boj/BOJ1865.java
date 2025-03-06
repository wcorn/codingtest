package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1865"> 웜홀 </a>
 */
public class BOJ1865 {

    private static int N;
    private static int M;
    private static int W;
    private static List<Pair>[] list;
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());

                addEdge(a, b, c);
                addEdge(b, a, c);
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = -Integer.parseInt(st.nextToken());

                addEdge(a, b, c);
            }

            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (bellman(i)) {
                    flag = true;
                    break;
                }
            }
            sb.append(flag ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }

    private static void addEdge(int a, int b, int c) {
        for (Pair p : list[a]) {
            if (p.node == b) {
                if (p.weight > c) {
                    p.weight = c;
                }
                return;
            }
        }
        list[a].add(new Pair(b, c));
    }

    private static boolean bellman(int start) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean flag;
        for (int i = 0; i < N - 1; i++) {
            flag = true;
            for (int j = 0; j < N; j++) {
                for (Pair p : list[j]) {
                    if (dist[j] != INF && dist[p.node] > dist[j] + p.weight) {
                        dist[p.node] = dist[j] + p.weight;
                        flag = false;
                    }
                }
            }
            if (flag) {
                return false;
            }
        }
        for (int j = 0; j < N; j++) {
            for (Pair p : list[j]) {
                if (dist[p.node] > dist[j] + p.weight) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {

        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
