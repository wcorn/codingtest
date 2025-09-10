package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1197"> 최소 스패닝 트리 </a>
 */
public class BOJ1197 {

    private static int V;
    private static int E;
    private static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        System.out.println(mst());
    }

    private static int mst() {
        boolean[] visited = new boolean[V];
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1[1], n2[1]));
        pq.add(new int[]{0, 0});
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (visited[temp[0]]) {
                continue;
            }
            visited[temp[0]] = true;
            cost += temp[1];
            for (int[] i : list[temp[0]]) {
                if(visited[i[0]])
                    continue;
                pq.add(i);
            }
        }
        return cost;
    }
}
