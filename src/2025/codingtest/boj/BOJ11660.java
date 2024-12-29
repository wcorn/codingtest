package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ11660 {

    private static int N;
    private static int M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N; i++) {
            map[i][0] += map[i - 1][0];
            map[0][i] += map[0][i - 1];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                map[i][j] += (map[i - 1][j] + map[i][j - 1]-map[i-1][j-1]);
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int temp = 0;
            temp+=map[x2][y2];
            if(x1!=0)
                temp-=map[x1-1][y2];
            if(y1!=0)
                temp-=map[x2][y1-1];
            if(x1!=0&&y1!=0)
                temp+=map[x1-1][y1-1];
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}
