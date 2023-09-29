package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ15652 {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] sequence;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        sequence = new int[M];
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        dfs(1,0);
    }
    private static void dfs(int now, int depth){
        if(M==depth){
            for(int i=0;i<M;i++){
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=now;i<=N;i++){
            sequence[depth] = i;
            dfs(i,depth+1);
        }
    }
}
