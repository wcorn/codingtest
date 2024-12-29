package codingtest.dynamicprograming;

import java.io.*;
import java.util.*;

public class BOJ2096 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] x = new int[3];
        int[] min = new int[3];
        int[] max = new int[3];
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int prevMin0;
        int prevMin2;
        int prevMax0;
        int prevMax2;
        for(int k=0;k<3;k++){
            int a = Integer.parseInt(st.nextToken());
            min[k] = a;
            max[k] = a;
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<3;k++){
                x[k] = Integer.parseInt(st.nextToken());
            }
            prevMin0 = min[0];
            prevMin2 = min[2];
            prevMax0 = max[0];
            prevMax2 = max[2];
            min[0] = Math.min(min[0],min[1])+x[0];
            min[2] = Math.min(min[1],min[2])+x[2];
            min[1] = Math.min(prevMin0,Math.min(min[1],prevMin2))+x[1];
            max[0] = Math.max(max[0],max[1])+x[0];
            max[2] = Math.max(max[1],max[2])+x[2];
            max[1] = Math.max(prevMax0,Math.max(max[1],prevMax2)) +x[1];
        }
        System.out.println(Math.max(max[0],Math.max(max[1],max[2])) +" "+Math.min(min[0],Math.min(min[1],min[2])));
    }
}
