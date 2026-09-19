import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        Map<Integer,Integer> m = new HashMap<>();
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++){
                int num = n+arr[j];
                m.put(num,m.getOrDefault(num,0)+1);
            }
        }   
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++){
                int num = (n+arr[j]) * -1;
                if(m.containsKey(num)){
                    ans+=m.get(num);
                }
            }
        } 
        System.out.println(ans);
    }
}