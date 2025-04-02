package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/3460"> 이진수 </a>
 */
public class BOJ3460 {

    private static int N;
    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            String t = Integer.toString(N,2);
            for(int j = t.length()-1;j>=0; j--){
                if(t.charAt(j)=='1') {
                    sb.append(t.length()-1-j).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
