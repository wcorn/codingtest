package codingtest.math;
import java.util.*;
public class BOJ87390 {
    public static void main(String[] args) {
        System.out.println(solution(4,7,14));
    }
    public static List<Long> solution(int n, long left, long right) {
        List<Long> answer = new ArrayList<>();
        for(long i=left;i<=right;i++){
            answer.add(Math.max(i/n,i%n)+1);
        }
        return answer;
    }
}
