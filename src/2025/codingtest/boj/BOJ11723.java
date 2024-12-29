package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ11723 {
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        M = Integer.parseInt(br.readLine());
        String offer;
        int num;
        Set<Integer> s = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            offer = st.nextToken();
            switch(offer){
                case "add" : {
                    num = Integer.parseInt(st.nextToken());
                    s.add(num);
                    break;
                }
                case "remove" : {
                    num = Integer.parseInt(st.nextToken());
                    s.remove(num);
                    break;
                }
                case "check" : {
                    num = Integer.parseInt(st.nextToken());
                    if(s.contains(num))
                        sb.append(1);
                    else
                        sb.append(0);
                    sb.append("\n");
                    break;
                }
                case "toggle" : {
                    num = Integer.parseInt(st.nextToken());
                    if(s.contains(num))
                        s.remove(num);
                    else
                        s.add(num);
                    break;
                }
                case "all" : {
                    s.clear();
                    for(int j =1; j <= 20; j++){
                        s.add(j);
                    }
                    break;
                }
                case "empty" : {
                    s.clear();
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
