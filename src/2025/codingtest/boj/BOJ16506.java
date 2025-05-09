package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/16506"> CPU </a>
 */
public class BOJ16506 {

    private static int N;
    private static Map<String, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        map = new HashMap<>();
        map.put("ADD", "00000");
        map.put("SUB", "00010");
        map.put("MOV", "00100");
        map.put("AND", "00110");
        map.put("OR", "01000");
        map.put("NOT", "01010");
        map.put("MULT", "01100");
        map.put("LSFTL", "01110");
        map.put("LSFTR", "10000");
        map.put("ASFTR", "10010");
        map.put("RL", "10100");
        map.put("RR", "10110");
        map.put("ADDC", "00001");
        map.put("SUBC", "00011");
        map.put("MOVC", "00101");
        map.put("ANDC", "00111");
        map.put("ORC", "01001");
        map.put("MULTC", "01101");
        map.put("LSFTLC", "01111");
        map.put("LSFTRC", "10001");
        map.put("ASFTRC", "10011");
        map.put("RLC", "10101");
        map.put("RRC", "10111");
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            String s1 = String.format("%3s", Integer.toBinaryString(Integer.parseInt(st.nextToken()))).replace(' ', '0');
            String s2 = String.format("%3s", Integer.toBinaryString(Integer.parseInt(st.nextToken()))).replace(' ', '0');
            String s3;
            if (opcode.charAt(opcode.length() - 1) == 'C') {
                s3 = String.format("%4s", Integer.toBinaryString(Integer.parseInt(st.nextToken()))).replace(' ', '0');
            } else {
                s3 = String.format("%3s", Integer.toBinaryString(Integer.parseInt(st.nextToken()))).replace(' ', '0') + "0";
            }
            sb.append(map.get(opcode)).append("0").append(s1).append(s2).append(s3).append("\n");

        }
        System.out.println(sb);
    }
}
