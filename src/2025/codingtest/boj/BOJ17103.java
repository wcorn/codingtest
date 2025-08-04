package codingtest.boj;
import java.util.*;
import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/17103"> 골드바흐 파티션 </a>
 */
public class BOJ17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[1_000_001];
        for(int i = 2; i <= 1_000_000; i++){
            prime[i] = isPrime(i);
        }
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j = 2; j <= N/2; j++){
                int n1 = j;
                int n2 = N-j;
                if(prime[n1]&&prime[n2]){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    private static boolean isPrime(int num) {
        if(num < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}