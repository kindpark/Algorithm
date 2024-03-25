package codeforces;

import java.io.*;

public class A_div2_0620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int x = Integer.parseInt(strArr[0]);
            int y = Integer.parseInt(strArr[1]);
            int a = Integer.parseInt(strArr[2]);
            int b = Integer.parseInt(strArr[3]);
            int yx = y - x;
            int ab = a + b;
            if(yx % ab == 0){
                sb.append(yx / ab).append("\n");
            }else{
                sb.append(-1).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
