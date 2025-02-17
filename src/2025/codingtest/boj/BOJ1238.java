package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1238"> 파티 </a>
 */
public class BOJ1238 {

    private static int N;
    private static int M;
    private static int X;
    private static List<int[]>[] list1;
    private static List<int[]>[] list2;
    private static int[] dist1;
    private static int[] dist2;
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list1 = new ArrayList[N + 1];
        list2 = new ArrayList[N + 1];
        dist1 = new int[N + 1];
        dist2 = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list1[a].add(new int[]{b, c});
            list2[b].add(new int[]{a, c});
        }
        solve(list1, dist1);
        solve(list2, dist2);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }
        System.out.println(answer);
    }

    private static void solve(List<int[]>[] list, int[] dist) {
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1[1], n2[1]));
        pq.add(new int[]{X, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (visited[temp[0]]) {
                continue;
            }
            visited[temp[0]] = true;
            for (int[] i : list[(temp[0])]) {
                if (visited[i[0]]) {
                    continue;
                }
                dist[i[0]] = Math.min(dist[i[0]], temp[1] + i[1]);
                pq.add(new int[]{i[0], dist[i[0]]});
            }
        }
    }
}
