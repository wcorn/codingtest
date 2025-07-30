package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/14267"> 회사 문화 1 </a>
 */
public class BOJ14267 {

    private static int n;
    private static int m;
    private static List<Integer>[] list;
    private static int[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) {
            list[Integer.parseInt(st.nextToken())].add(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        solve();
        for(int i = 1; i <= n;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : list[now]) {
                arr[i] += arr[now];
                q.add(i);
            }
        }
    }
}
