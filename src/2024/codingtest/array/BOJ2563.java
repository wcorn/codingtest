package codingtest.array;

import java.io.*;
import java.util.*;

public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[100][100];
        int a,b;
        int answer=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    board[a+j][b+k]=true;
                }
            }
        }
        for(int j=0;j<100;j++){
            for(int k=0;k<100;k++){
                if(board[j][k])
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
