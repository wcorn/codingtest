package codingtest.math;

import java.io.*;
import java.util.*;

public class BOJ9506 {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            solve(n);
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    private static void solve(int n) {
        int sum = 0;
        List<Integer> a = new ArrayList<>();
        sb.append(n);
        for (int i = 1; i < n; i++) {
            if (n%i==0) {
                sum += i;
                a.add(i);
            }
        }
        if(sum==n){
            sb.append(" = ").append(a.get(0));
            for(int i=1;i<a.size();i++){
                sb.append(" + ").append(a.get(i));
            }
        }
        else{
            sb.append(" is NOT perfect.");
        }
        sb.append("\n");
    }
}
