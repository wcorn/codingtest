package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ2096 {
    private static int n;
    private static int[][] min;
    private static int[][] max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        min= new int[n][3];
        max = new int[n][3];
        st = new StringTokenizer(br.readLine());
        min[0][0] = Integer.parseInt(st.nextToken());
        min[0][1] = Integer.parseInt(st.nextToken());
        min[0][2] = Integer.parseInt(st.nextToken());
        max[0][0] = min[0][0];
        max[0][1] = min[0][1];
        max[0][2] = min[0][2];
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            min[i][0] = a + Math.min(min[i-1][0],min[i-1][1]);
            min[i][1] = b+ Math.min(min[i-1][0],Math.min(min[i-1][1],min[i-1][2]));
            min[i][2] = c + Math.min(min[i-1][1],min[i-1][2]);
            max[i][0] = a + Math.max(max[i-1][0],max[i-1][1]);
            max[i][1] = b + Math.max(max[i-1][0],Math.max(max[i-1][1],max[i-1][2]));
            max[i][2] = c + Math.max(max[i-1][1],max[i-1][2]);
        }
        System.out.println(Math.max(max[n-1][0],Math.max(max[n-1][1],max[n-1][2]))+" "+Math.min(min[n-1][0],Math.min(min[n-1][1],min[n-1][2])));
    }
}
