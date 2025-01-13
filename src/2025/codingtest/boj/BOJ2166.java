package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2166"> 다각형의 면적 </a>
 */
public class BOJ2166 {

    private static int n;
    private static long[][] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        point = new long[n+1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Long.parseLong(st.nextToken());
            point[i][1] = Long.parseLong(st.nextToken());
        }
        point[n][0] = point[0][0];
        point[n][1] = point[0][1];
        double s1 = 0;
        double s2 = 0;
        for (int i = 0; i < n; i++) {
            s1+=point[i][0]*point[i+1][1];
            s2+=point[i][1]*point[i+1][0];
        }
        System.out.printf("%.1f",Math.abs((s1-s2)/2));
    }
}
