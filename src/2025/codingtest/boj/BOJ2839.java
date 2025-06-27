package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2839"> 설탕 배달 </a></a>
 */
public class BOJ2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int cnt = N /5;
        boolean flag = true;
        for(int i = cnt; i>=0; i--){
            if((N-i*5)%3==0){
                flag = false;
                System.out.println(i+(N-i*5)/3);
                break;
            }
        }
        if(flag){
            System.out.println(-1);
        }
    }
}
