package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1043"> 거짓말 </a>
 */
public class BOJ1043 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static List<Integer>[] list;
    private static Set<Integer> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        list = new ArrayList[M];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        s = new HashSet<>();
        for (int i = 0; i < k; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            list[i].add(num1);
            for (int j = 0; j < t - 1; j++) {
                int num2 = Integer.parseInt(st.nextToken());
                list[i].add(num2);
                union(num1, num2);
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            b:
            for (int t : list[i]) {
                for (int j : s) {
                    if (find(t) == find(j)) {
                        flag = false;
                        break b;
                    }
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void union(int num1, int num2) {
        int n1 = find(num1);
        int n2 = find(num2);
        if (n1 > n2) {
            arr[n1] = n2;
        } else if (n1 < n2) {
            arr[n2] = n1;
        }
    }

    private static int find(int num) {
        if (num == arr[num]) {
            return num;
        }
        return arr[num] = find(arr[num]);
    }
}
