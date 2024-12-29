package codingtest.math;

import java.io.*;
import java.util.*;
public class BOJ5086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int a ,b;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a==0&&b==0)
                break;
            if(a%b==0)
                sb.append("multiple").append("\n");
            else if(b%a==0)
                sb.append("factor").append("\n");
            else
                sb.append("neither").append("\n");
        }
        System.out.println(sb);
    }
}
