package codingtest.math;

import java.io.*;

public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int i = 2;
        while (N != 1) {
            if (N % i == 0) {
                N /= i;
                sb.append(i).append("\n");
            }
            else i++;
        }
        if(sb.length()>1) {
            sb.setLength(sb.length() - 1);
            System.out.print(sb);
        }
    }
}