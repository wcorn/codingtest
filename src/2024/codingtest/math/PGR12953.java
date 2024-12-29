package codingtest.math;

public class PGR12953 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
    }
    public static int solution(int[] arr) {
        if(arr.length==1)
            return arr[0];
        int gc = gcd(arr[0], arr[1]);
        int answer = (arr[0] * arr[1]) / gc;
        for(int i = 2; i < arr.length; i++) {
            gc = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / gc;
        }
        return answer;
    }
    public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
