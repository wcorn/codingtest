import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        TreeMap<String,Integer> m = new TreeMap<>((s1,s2) -> s1.compareTo(s2));
        int cnt = 0;
        for(int i =0;i<N;i++){
            String str = br.readLine();
            m.put(str,m.getOrDefault(str,0)+1);
            cnt++;
        }
        for(String str : m.keySet()){
            sb.append(str).append(" ").append(String.format("%.4f", (float) m.get(str)/cnt*100)).append("\n");
        }
        System.out.println(sb);
    }
}