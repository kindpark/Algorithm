package codeforces;

import java.io.*;

public class C_0654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            long a = Long.parseLong(strArr[0]);
            long b = Long.parseLong(strArr[1]);
            long m = Long.parseLong(strArr[2]);
            long n = Long.parseLong(strArr[3]);
            if(a + b < m + n){
                sb.append("No");
            }else{
                long abMax = Math.max(a, b);
                long abMin = Math.min(a, b);
                long mnMax = Math.max(m, n);
                long mnMin = Math.min(m, n);
                if(abMin >= n){
                    sb.append("Yes");
                }else{
                    sb.append("No");
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
