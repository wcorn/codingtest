package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ11404 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i],INF);
            map[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }
        fluid();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (map[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void fluid() {
        for(int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int t = 0; t < n; t++) {
                    map[k][t] = Math.min(map[k][t], map[k][i] + map[i][t]);
                }
            }
        }
    }
}
