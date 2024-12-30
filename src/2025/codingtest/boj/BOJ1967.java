package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1967 {

    private static int n;
    private static List<int[]>[] list;
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        int a, b, c;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        int[] arr = dijkstra(0);
        arr = dijkstra(arr[0]);
        System.out.println(arr[1]);
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1[1], n2[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if(visited[temp[0]])
                continue;
            visited[temp[0]] = true;
            for(int[] i : list[temp[0]]) {
                dist[i[0]] = Math.min(dist[i[0]],temp[1]+i[1]);
                pq.add(new int[]{i[0],dist[i[0]]});
            }
        }
        int index = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(dist[i]==INF)
                continue;
            if(max<dist[i]){
                index = i;
                max = dist[i];
            }
        }
        return new int[]{index,max};
    }
}
