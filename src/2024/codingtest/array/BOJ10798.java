package codingtest.array;

import java.io.*;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] ch = new char[5][15];
        String str;
        for (int i = 0; i < 5; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                ch[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch[j][i] != 0)
                    sb.append(ch[j][i]);
            }
        }
        System.out.println(sb);
    }
}
