package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/20040"> 사이클 게임 </a>
 */
public class BOJ20040 {

    private static int n;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (answer != 0) {
                continue;
            }
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int ra = findRoot(a);
            int rb = findRoot(b);
            if (ra == rb) {
                answer = i + 1;
            } else {
                arr[ra] = rb;
            }
        }
        System.out.println(answer);
    }

    private static int findRoot(int num) {
        if (arr[num] == num) {
            return num;
        }
        return findRoot(arr[num]);
    }
}
