package codingtest.string;

import java.io.*;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int answer = 1;
        for (int i = 0; i < ch.length / 2; i++) {
            if (ch[i] != ch[ch.length - 1 - i]) {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }
}
