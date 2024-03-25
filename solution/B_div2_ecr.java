package codeforces;

import java.io.*;

public class B_div2_ecr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int g = Integer.parseInt(strArr[1]);
            int b = Integer.parseInt(strArr[2]);
            sb.append(find(n, g, b)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static long find(int n, int g, int b) {
        if(n <= g){
            return n;
        }
        long halfN = (n % 2 == 0) ? n / 2 : n / 2 + 1;
        long period = g + b;
        long highQFreq = halfN / g;
        long rest = halfN % g;
        if(rest == 0){
            long value = period * highQFreq - b;
            if(value >= n){
                return value;
            }
            return n;
        }
        long value2= period * highQFreq + rest;
        if(value2 >= n){
            return value2;
        }
        return n;
    }
}
