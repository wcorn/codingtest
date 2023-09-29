package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int A, B;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(solve(A, B)).append("\n");
        }
        System.out.println(sb);
    }

    private static String solve(int A, int B) {
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        command[A]="";
        visited[A] = true;
        int now;
        int d, s, l, r;
        while (!q.isEmpty()) {
            now = q.poll();
            if (now == B)
                return command[now];
            d = D(now);
            s = S(now);
            l = L(now);
            r = R(now);
            if (!visited[d]){
                q.add(d);
                command[d] = command[now]+"D";
                visited[d] = true;
            }
            if (!visited[s]){
                q.add(s);
                command[s] = command[now]+"S";
                visited[s] = true;
            }
            if (!visited[l]){
                q.add(l);
                command[l] = command[now]+"L";
                visited[l] = true;
            }
            if (!visited[r]){
                q.add(r);
                command[r] = command[now]+"R";
                visited[r] = true;
            }
        }
        return null;
    }

    private static int D(int value) {
        return (value * 2) % 10000;
    }

    private static int S(int value) {
        if (value == 0)
            return 9999;
        return value - 1;
    }

    private static int L(int value) {
        return (value * 10) % 10000 + value / 1000;
    }

    private static int R(int value) {
        return (value % 10) * 1000 + value / 10;
    }
}
