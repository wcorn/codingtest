import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> m = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> m.get(a) < m.get(b) ? 1 :(m.get(a) > m.get(b) ? -1 : b-a));
        for(int i = 0 ; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            m.put(n,m.getOrDefault(n,0)+1);
        }
        for(int i : m.keySet()){
            pq.add(i);
        }
        for(int i = 0; i < K; i++){
            sb.append(pq.remove()).append(" ");
        }
        System.out.println(sb);
    }
}