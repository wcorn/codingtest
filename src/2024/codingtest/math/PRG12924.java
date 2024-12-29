package codingtest.math;

public class PRG12924 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    public static int solution(int n) {
        int answer = 0;
        int temp;
        int k;
        for(int i=1;i<=n;i++){
            temp = i;
            k=i;
            while(temp<n){
                temp+=++k;
            }
            if(temp==n)
                answer++;
        }
        return answer;
    }
}
