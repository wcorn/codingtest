package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ1865 {
    private static int TC;
    private static int N;
    private static int M;
    private static int W;
    private static int[][] map;
    private static int[] dist;
    private static final int INF = 50_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num1, num2, value;
        TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            dist = new int[N];
            for (int k = 0; k < N; k++)
                Arrays.fill(map[k], INF);
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                num1 = Integer.parseInt(st.nextToken()) - 1;
                num2 = Integer.parseInt(st.nextToken()) - 1;
                value = Integer.parseInt(st.nextToken());
                map[num1][num2] = Math.min(map[num1][num2], value);
                map[num2][num1] = map[num1][num2];
            }
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = -Integer.parseInt(st.nextToken());
            }
            if (solve())
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean solve() {
        for (int n = 0; n < N - 1; n++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (dist[i] + map[i][j] < dist[j])
                        dist[j] = dist[i] + map[i][j];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (dist[i] + map[i][j] < dist[j])
                    return true;
        return false;
    }
}
