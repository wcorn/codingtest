import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        for(char c : arr) {
            m.put(c,m.getOrDefault(c,0)+1);
        }
        String ans = "None";
        for(char c : arr) {
            if(m.get(c) == 1){
                ans = String.valueOf(c);
                break;
            }
        }
        System.out.println(ans);
    }
}