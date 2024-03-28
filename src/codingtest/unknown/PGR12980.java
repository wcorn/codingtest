package codingtest.unknown;

public class PGR12980 {
    public static void main(String[] args) {
        System.out.println(solution(13));
    }

    public static int solution(int n) {
        int ans = 0;
        while(n!=0){
            if(n%2==0)
                n/=2;
            else{
                n-=1;
                ans++;
            }
        }
        return ans;
    }
}
