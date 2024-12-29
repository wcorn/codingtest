package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1389 {
    private static List<Integer>[] list;
    private static int n;
    private static int m;
    private static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for(int i = 0; i < n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            list[a].add(b);
            list[b].add(a);
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = dijkstra(i);
        }
        int answer = n-1;
        for(int i = n-2; i>=0; i--){
            if(arr[i]<=arr[answer])
                answer = i;
        }
        System.out.println(answer+1);
    }
    private static int dijkstra(int num){
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist,INF);
        dist[num] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[1]==p2[1]?Integer.compare(p1[0],p2[0]):Integer.compare(p1[1],p2[1]));
        pq.add(new int[]{num,0});
        int[] temp;
        List<Integer> tempList;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(visited[temp[0]])
                continue;
            visited[temp[0]] = true;
            tempList = list[temp[0]];
            for(int i : tempList){
                dist[i] = Math.min(dist[i],temp[1]+1);
                pq.add(new int[]{i,dist[i]});
            }
        }
        int sum = 0;
        for(int i : dist){
            sum+=i;
        }
        return sum;
    }
}
