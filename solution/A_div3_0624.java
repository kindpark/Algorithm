package codeforces;

import java.io.*;

public class A_div3_0624 {
    private static int t = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            if(a == b){
                sb.append(0);
            }else{
                if(a < b && (b - a) % 2 == 1){
                    sb.append(1);
                }else if(a < b && (b - a) % 2 == 0){
                    sb.append(2);
                }else if(a > b && (a - b) % 2 == 0){
                    sb.append(1);
                }else{
                    sb.append(2);
                }
            }
            sb.append("\n");
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
