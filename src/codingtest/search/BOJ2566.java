package codingtest.search;

import java.util.*;
import java.io.*;

public class BOJ2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0;
        int temp;
        int x = 0, y = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                temp = Integer.parseInt(st.nextToken());
                if (max < temp) {
                    max = temp;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((x+1) + " " + (y+1));
    }
}
