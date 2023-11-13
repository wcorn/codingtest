package codingtest.search;

import java.util.Arrays;

public class PGR150368 {
    public static void main(String[] args){
        int[] emoticons = {7000, 9000};
        int[][] users = {{40,10000},{25, 10000}};
        System.out.println(Arrays.toString(solution(users, emoticons)));
    }
    static int sign=0;
    static int earn=0;
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer =new int[2];
        int[] sales =new int[emoticons.length];
        dfs(0,sales,users,emoticons);
        answer[0] = sign;
        answer[1] = earn;
        return answer;
    }
    public static void dfs(int index, int[] sales,int[][] users,int[] emoticons){
        if(index==sales.length){
            calculate(sales,users,emoticons);
            return;
        }
        for(int i=10;i<=40;i+=10){
            sales[index]=i;
            dfs(index+1,sales,users,emoticons);
        }
    }
    public static void calculate(int[] sales,int[][] users,int[] emoticons){
        int count=0;
        int earn_t=0;
        int[] result = new int[users.length];
        for(int i=0;i<users.length;i++){
            for(int j=0;j<sales.length;j++){
                if(sales[j]>=users[i][0]){
                    result[i]+=emoticons[j]*(100-sales[j])/100;
                }
            }
            if(result[i]>=users[i][1]){
                result[i]=0;
                count++;
            }
            earn_t+=result[i];
        }
        if(sign<count){
            sign = count;
            earn = earn_t;
        }
        else if(count==sign){
            if(earn<earn_t){
                earn=earn_t;
            }
        }
    }
}
