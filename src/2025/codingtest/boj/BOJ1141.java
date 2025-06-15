package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1141"> 접두사 </a>
 */
public class BOJ1141 {

    private static int N;
    private static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        Collections.sort(list, (n1, n2) -> n2.length() - n1.length());
        List<String> l = new ArrayList<>();
        l.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            boolean flag = true;
            for (String s : l) {
                if(s.startsWith(list.get(i))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                l.add(list.get(i));
            }
        }
        System.out.println(l.size());
    }
}
