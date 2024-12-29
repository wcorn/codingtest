package codingtest.datastructure;

import java.util.*;

public class PGR49994 {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
    static List<Point> list;
    public static int solution(String dirs) {
        int answer = 0;
        char[] ch = dirs.toCharArray();
        list = new ArrayList<>();
        Point now = new Point(0,0);
        int dx=0, dy=0;
        list.add(new Point(0,0));
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='U'){
                dx = now.x;
                dy = now.y+1;
            } else if(ch[i]=='L'){
                dx = now.x-1;
                dy = now.y;
            } else if(ch[i]=='R'){
                dx = now.x+1;
                dy = now.y;
            } else if(ch[i]=='D'){
                dx = now.x;
                dy = now.y-1;
            }
            if(dx<-5||dx>5||dy<-5||dy>5){
                continue;
            }
            if(check(now.x, now.y, dx, dy)){
                answer++;
            }
            list.add(new Point(dx, dy));
            now = new Point(dx,dy);
        }
        return answer;
    }
    public static boolean check(int x, int y, int dx, int dy){
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).x==x&&
                list.get(i).y==y&&
                list.get(i+1).x==dx&&
                list.get(i+1).y==dy||
                list.get(i).x==dx&&
                    list.get(i).y==dy&&
                    list.get(i+1).x==x&&
                    list.get(i+1).y==y)
                return false;
        }
        return true;
    }
    public static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
        public String toString(){
            return x+" "+y;
        }
    }
}
