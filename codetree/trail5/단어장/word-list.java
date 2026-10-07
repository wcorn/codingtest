import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tr = new TreeMap<>();
        for(int i = 0;i < N; i++){
            String str = br.readLine();
            tr.put(str,tr.getOrDefault(str,0)+1);
        }
        for(String str : tr.keySet()){
            sb.append(str).append(' ').append(tr.get(str)).append("\n");
        }
        System.out.println(sb);
    }
}