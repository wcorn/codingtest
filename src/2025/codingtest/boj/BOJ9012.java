package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/9012"> 괄호 </a>
 */
public class BOJ9012 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            int count = 0;
            boolean flag = true;
            for (char c : ch) {
                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    if (count == 0) {
                        flag = false;
                        break;
                    }
                    count--;
                }
            }
            if (count > 0) {
                flag = false;
            }
            if (flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
