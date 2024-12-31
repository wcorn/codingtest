package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ15650 {
    private static int N;
    private static int M;
    private static int[] dist;
    private static boolean[] visited;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[M];
        visited = new boolean[N+1];
        dfs(0,1);
        System.out.println(sb);
    }
    private static void dfs(int depth, int now){
        if(depth==M){
            for(int i = 0; i < M; i++){
                sb.append(dist[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = now; i <= N; i++){
            if(visited[i])
                continue;
            dist[depth] = i;
            visited[i] = true;
            dfs(depth+1,i+1);
            visited[i] = false;
        }
    }
}
