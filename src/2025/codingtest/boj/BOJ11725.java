package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ11725 {

    private static int N;
    private static List<Set> list;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        answer = new int[N+1];
        for (int i = 0; i <= N; i++) {
            list.add(new HashSet<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int n = q.poll();
            Set<Integer> s = list.get(n);
            for (int i : s) {
                if(visited[i])
                    continue;
                answer[i] = n;
                q.add(i);
                visited[i] = true;
            }
        }
        for(int i = 2;i <= N; i++){
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}
