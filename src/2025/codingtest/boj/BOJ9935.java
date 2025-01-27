package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/9935"> 문자열 폭발 </a>
 */
public class BOJ9935 {

    private static char[] ch;
    private static char[] bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ch = br.readLine().toCharArray();
        bomb = br.readLine().toCharArray();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            s.add(ch[i]);
            if (s.size() >= bomb.length) {
                boolean flag = true;
                while (flag&&s.size()>=bomb.length) {
                    for (int j = 0; j < bomb.length; j++) {
                        if (s.get(s.size() - 1 - j) != bomb[bomb.length - 1 - j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = 0; j < bomb.length; j++) {
                            s.pop();
                        }
                    }
                }
            }
        }
        if (s.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for(char c : s){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
