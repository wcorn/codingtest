package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ11053 {
    private static int aSize;
    private static int[] A;
    private static int[] result;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        aSize = Integer.parseInt(br.readLine());
        A = new int[aSize];
        result = new int[aSize];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<aSize;i++){
            A[i] = Integer.parseInt(st.nextToken());
            result[i] = 1;
        }
        answer = 1;
        solve(0);
        System.out.println(answer);
    }
    private static void solve(int now){
        if(now==aSize)
            return;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=0;i<now;i++){
            if(A[i]<A[now]){
                max = Math.max(max,result[i]);
                flag = true;
            }
        }
        if(flag){
            result[now] = max+1;
            answer = Math.max(answer,result[now]);
        }
        solve(now+1);
    }
}
