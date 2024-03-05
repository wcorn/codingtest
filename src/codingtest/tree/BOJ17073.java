package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ17073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double water = Double.parseDouble(st.nextToken());
        int count=0;
        int[] nodes = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[Integer.parseInt(st.nextToken())]++;
            nodes[Integer.parseInt(st.nextToken())]++;
        }
        for (int i = 2; i <= N; i++) {
            if(nodes[i]<2){
                count++;
            }
        }
        System.out.printf("%.10f",water/count);
    }
}
