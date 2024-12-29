package codingtest.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ15036 {

    public static void main(String[] args){
        String[] commands = {};
        System.out.println(Arrays.toString(solution(commands)));

    }
    static int uniqueKey = 0;

    public static String[] solution(String[] commands) {
        Node[][] map = new Node[5][5];
        List<String> result = new ArrayList<>();
        String query;
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                map[i][j] = new Node(uniqueKey++,"EMPTY");
            }
        }
        for(int i=0;i<commands.length;i++){
            String[] command;
            command = commands[i].split(" ");
            query = command[0];
            if(query.equals("UPDATE")){
                if(command.length==4){
                    UPDATE1(Integer.parseInt(command[1]),Integer.parseInt(command[2]),command[3],map);
                }
                if(command.length==3){
                    UPDATE2(command[1],command[2],map);
                }
            }
            else if(query.equals("MERGE")){
                MERGE(Integer.parseInt(command[1]),Integer.parseInt(command[2]),Integer.parseInt(command[3]),Integer.parseInt(command[4]),map);
            }
            else if(query.equals("UNMERGE")){
                UNMERGE(Integer.parseInt(command[1]),Integer.parseInt(command[2]),map);
            }
            else if(query.equals("PRINT")){
                result.add(PRINT(Integer.parseInt(command[1]),Integer.parseInt(command[2]),map));
            }
        }
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                System.out.print(map[i][j].key+" ");
            }
            System.out.println();
        }
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                System.out.print(map[i][j].word+" ");
            }
            System.out.println();
        }
        return result.toArray(new String[0]);
    }
    public static void UPDATE1(int r, int c, String value, Node[][] map){
        int key = map[r][c].key;
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                if(map[i][j].key==key)
                    map[i][j].word = value;
            }
        }
    }
    public static void UPDATE2(String value1, String value2, Node[][] map){
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                if(map[i][j].word.equals(value1))
                    map[i][j].word = value2;
            }
        }
    }
    public static void MERGE(int r1, int c1, int r2, int c2, Node[][] map){
        if(r1==r2&&c1==c2)
            return;
        int mainKey = map[r1][c1].key;
        int subKey = map[r2][c2].key;
        String word = map[r1][c1].word;
        if(word.equals("EMPTY")&&!map[r2][c2].word.equals("EMPTY")){
            word = map[r2][c2].word;
            mainKey = map[r2][c2].key;
            subKey = map[r1][c1].key;
        }
        System.out.println(mainKey+" "+subKey);
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                if(map[i][j].key==subKey){
                    map[i][j].key = mainKey;
                    map[i][j].word = word;
                }
            }
        }
    }
    public static void UNMERGE(int r,int c, Node[][] map){
        int mainKey = map[r][c].key;
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                if(map[i][j].key==mainKey){
                    if(i==r&&j==c)
                        continue;
                    if(map[i][j].key == mainKey){
                        map[i][j].key = uniqueKey++;
                        map[i][j].word = "EMPTY";
                    }
                }
            }
        }
    }
    public static String PRINT(int r, int c, Node[][] map){
        return map[r][c].word;
    }
    public static class Node{
        int key;
        String word;
        public Node(int key, String word){
            this.key = key;
            this.word = word;
        }
    }
}
