package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1620 {
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String,Integer> strM = new HashMap<>();
        Map<Integer,String> intM = new HashMap<>();
        String temp;
        for(int i = 1; i <= N; i++){
            temp = br.readLine();
            strM.put(temp,i);
            intM.put(i,temp);
        }
        for(int i = 0; i < M; i++){
            temp = br.readLine();
            if(isInteger(temp)){
                sb.append(intM.get(Integer.parseInt(temp)));
            }
            else
                sb.append(strM.get(temp));
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static boolean isInteger(String num){
        try{
            Integer.parseInt(num);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
