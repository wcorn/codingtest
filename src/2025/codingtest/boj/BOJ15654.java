package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ15654 {
    private static StringBuilder sb;
    private static int[] dist;
    private static int[] answer;
    private static boolean[] visited;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N];
        answer = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dist);
        dfs(0);
        System.out.println(sb);
    }
    private static void dfs(int depth) {
        if(depth==M){
            for(int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            answer[depth] = dist[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }
}
