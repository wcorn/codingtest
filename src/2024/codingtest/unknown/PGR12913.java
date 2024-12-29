package codingtest.unknown;

public class PGR12913 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
    private static int solution(int[][] land) {
        int sum;
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                sum =0;
                for(int k=0;k<4;k++){
                    if(j==k) continue;
                    sum = Math.max(sum,land[i][j]+land[i-1][k]);
                }
                land[i][j] = sum;
            }
        }
        sum =0;
        for(int k=0;k<4;k++){
            sum = Math.max(sum,land[land.length-1][k]);
        }
        return sum;
    }
}
