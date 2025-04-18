package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/1316"> 그룹 단어 체커 </a>
 */
public class BOJ1316 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (check(br.readLine().toCharArray())) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(char[] ch) {
        boolean[] visited = new boolean[26];
        char before = ch[0];
        visited[before - 'a'] = true;
        for (int i = 1; i < ch.length; i++) {
            if (before != ch[i]) {
                if (visited[ch[i] - 'a']) {
                    return false;
                }
                before = ch[i];
                visited[before - 'a'] = true;
            }
        }
        return true;
    }
}
