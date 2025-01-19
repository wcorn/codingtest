package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/13549"> 숨바꼭질 3 </a>
 */
public class BOJ13549 {

    private static int N;
    private static int K;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited = new boolean[100001];
        visited[N] = true;
        int answer = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == K) {
                answer = temp[1];
                break;
            }
            if (temp[0] * 2 <= 100000 && !visited[temp[0] * 2]) {
                visited[temp[0] * 2] = true;
                q.addFirst(new int[]{temp[0] * 2, temp[1]});
            }
            if (temp[0] - 1 >= 0 && !visited[temp[0] - 1]) {
                visited[temp[0] - 1] = true;
                q.addLast(new int[]{temp[0] - 1, temp[1] + 1});
            }
            if (temp[0] + 1 <= 100000 && !visited[temp[0] + 1]) {
                visited[temp[0] + 1] = true;
                q.addLast(new int[]{temp[0] + 1, temp[1] + 1});
            }
        }
        System.out.println(answer);
    }
}
