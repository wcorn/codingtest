package codingtest.string;

public class PGR17687 {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(solution(n,t,m,p));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder nBase = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(int i = 0; nBase.length() <= t * m; i++){
            nBase.append(Integer.toString(i, n));
        }
        for(int i = p - 1;  answer.length() < t; i += m){
            answer.append(nBase.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}
