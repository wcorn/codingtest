package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2738"> 행렬 덧셈 </a>
 */
public class BOJ2738 {
    private static int N;
    private static int M;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr =new int[N][M];
        for(int i = 0; i< N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++){
                arr[i][j] += Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i< N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++){
                arr[i][j] += Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i< N;i++){
            for(int j = 0;j<M;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
