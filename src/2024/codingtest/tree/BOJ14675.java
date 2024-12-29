package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ14675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        int a;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1]++;
            map[Integer.parseInt(st.nextToken())-1]++;
        }
        a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                if (map[Integer.parseInt(st.nextToken())-1] > 1)
                    sb.append("yes").append("\n");
                else
                    sb.append("no").append("\n");
            } else
                sb.append("yes").append("\n");
        }
        System.out.println(sb);
    }
}
