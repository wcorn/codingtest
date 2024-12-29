package codingtest.math;

import java.io.*;

public class BOJ11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        System.out.println(Integer.toString(N,B).toUpperCase());
    }
}
