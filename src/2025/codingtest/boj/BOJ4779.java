package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/4779"> 칸토어 집합 </a>
 */
public class BOJ4779 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        list.add("-");
        for (int i = 1; i <= 12; i++) {
            StringBuilder str = new StringBuilder(list.get(i - 1));
            for (int j = 0; j < list.get(i - 1).length(); j++) {
                str.append(" ");
            }
            str.append(list.get(i - 1));
            list.add(str.toString());
        }
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            sb.append(list.get(n)).append("\n");
            System.out.println(sb);
        }
        System.out.println(sb);
    }
}
