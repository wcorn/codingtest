package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/11779"> 최소비용 구하기 2 </a>
 */
public class BOJ11779 {

    private static int n;
    private static int m;
    private static int s;
    private static int e;
    private static List<int[]>[] list;
    private static final int INF = 1_000_000_000;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;
        dijkstra();
        System.out.println(sb);
    }

    private static void dijkstra() {
        int[] dist = new int[n];
        int[] visit = new int[n];
        Arrays.fill(dist, INF);
        Arrays.fill(visit, INF);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (dist[temp[0]] < temp[1]) {
                continue;
            }
            for (int[] i : list[temp[0]]) {
                if (dist[i[0]] > dist[temp[0]] + i[1]) {
                    dist[i[0]] = dist[temp[0]] + i[1];
                    visit[i[0]] = temp[0];
                    pq.add(new int[]{i[0], dist[i[0]]});
                }
            }
        }
        int now = e;
        Stack<Integer> channel = new Stack<>();
        channel.add(now);
        while (now != s) {
            channel.add(visit[now]);
            now = visit[now];
        }
        sb.append(dist[e]).append("\n");
        sb.append(channel.size()).append("\n");
        while (!channel.isEmpty()) {
            sb.append(channel.pop() + 1).append(" ");
        }
    }

}
