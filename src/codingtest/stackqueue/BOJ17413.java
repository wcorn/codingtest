package codingtest.stackqueue;

import java.io.*;
import java.util.*;

public class BOJ17413 {
    private static char[] S;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().toCharArray();
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < S.length; i++) {
            if (S[i] == '<') {
                while (S[i] != '>') {
                    sb.append(S[i]);
                    i++;
                }
                sb.append(S[i]);
            } else if (S[i] == ' ')
                sb.append(' ');
            else {
                while (S[i] != ' ' && S[i] != '<') {
                    s.push(S[i]);
                    i++;
                    if (S.length <= i)
                        break;
                }
                i--;
                while (!s.isEmpty()) {
                    sb.append(s.pop());
                }
            }
        }
    }
}
