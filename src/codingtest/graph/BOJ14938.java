package codingtest.graph;

import java.io.*;
import java.util.*;

public class BOJ14938 {
    private static int n;
    private static int m;
    private static int r;
    private static int[] items;
    private static int[][] map;
    private static final int INF = 1501;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n];
        map = new int[n][n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                map[i][j] = INF;
            }
        }
        for (int i = 0; i < n; i++) {
            map[i][i] = 0;
        }
        int a, b, l;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            l = Integer.parseInt(st.nextToken());
            if (map[a][b] > l)
                map[a][b] = l;
            if (map[b][a] > l)
                map[b][a] = l;
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
        result = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= m)
                    temp += items[j];
            }
            result = Math.max(result, temp);
        }
    }
}
