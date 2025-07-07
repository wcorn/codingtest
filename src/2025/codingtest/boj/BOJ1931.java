package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1931"> 회의실 배정 </a>
 */
public class BOJ1931 {

    private static int N;
    private static List<int[]> list;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        list.sort((n1, n2) -> n1[1] == n2[1] ?
            Integer.compare(n1[0], n2[0]) : Integer.compare(n1[1], n2[1]));
        dp = new int[list.get(list.size() - 1)[1] + 1];
        int count = 0;
        int last = 0;
        for(int[] i : list){
            if(i[0]>=last){
                count++;
                last = i[1];
            }
        }
        System.out.println(count);
    }
}
