package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1753 {

    private static int V;
    private static int E;
    private static Map<Integer, Integer>[] list;
    private static StringBuilder sb = new StringBuilder();
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine())-1;
        list = new HashMap[V];
        for (int i = 0; i < V; i++) {
            list[i] = new HashMap<>();
        }
        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());
            list[u].put(v, Math.min(list[u].getOrDefault(v, 10), w));
        }
        dijkstra(K);
        System.out.println(sb);
    }

    private static void dijkstra(int k) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist,INF);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)->Integer.compare(n1[1],n2[1]));
        pq.add(new int[]{k,0});
        int[] temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(visited[temp[0]])
                continue;
            visited[temp[0]] = true;
            for(int i : list[temp[0]].keySet()){
                dist[i] = Math.min(dist[i],dist[temp[0]]+list[temp[0]].get(i));
                pq.add(new int[]{i,dist[i]});
            }
        }
        for(int i : dist){
            if(i==INF)
                sb.append("INF");
            else
                sb.append(i);
            sb.append("\n");
        }
    }
}
