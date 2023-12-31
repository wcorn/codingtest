package codingtest.string;
import java.util.*;
public class PGR17686 {
    public static void main(String[] args){
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));
    }
    private static String[] solution(String[] files) {
        char[] a;
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                int compareHead = head1.toUpperCase().compareTo(head2.toUpperCase());
                if(compareHead != 0)
                    return compareHead;
                s1 = s1.substring(head1.length());
                s2 = s2.substring(head2.length());
                String number1 = "";
                String number2 = "";
                for(char c : s1.toCharArray()) {
                    if(Character.isDigit(c) && number1.length()<=5)
                        number1 += c;
                    else
                        break;
                }
                for(char c : s2.toCharArray()) {
                    if(Character.isDigit(c) && number2.length()<=5)
                        number2 += c;
                    else
                        break;
                }
                return Integer.parseInt(number1) - Integer.parseInt(number2);
            }
        });
        return files;
    }
}
