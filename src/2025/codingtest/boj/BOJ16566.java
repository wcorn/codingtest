package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16566"> 카드 게임 </a>
 */
public class BOJ16566 {

    private static int N;
    private static int M;
    private static int K;
    private static int[] arr;
    private static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M];
        index = new int[M];
        for (int i = 1; i < M; i++) {
            index[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr);
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = Arrays.binarySearch(arr, num);
            index = index < 0 ? -(index + 1) : index + 1;
            int n = find(index);
            sb.append(arr[n]).append("\n");
            if (n + 1 < M) {
                union(n, n + 1);
            }
        }
        System.out.println(sb);
    }

    private static int find(int num) {
        if (index[num] == num) {
            return num;
        }
        return index[num] = find(index[num]);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x > y) {
            index[y] = x;
        } else if (x < y) {
            index[x] = y;
        }
    }
}
