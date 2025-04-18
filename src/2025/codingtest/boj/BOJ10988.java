package codingtest.boj;

import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/10988"> 팰린드롬인지 확인하기 </a>
 */
public class BOJ10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < ch.length / 2; i++) {
            int ri = ch.length - 1 - i;
            if (ch[i] != ch[ri]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
