import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                sb.append('*');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}