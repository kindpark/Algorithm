package codeforces;

import java.io.*;

public class A_global_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().split(" ");
            boolean isPossible = false;
            for (int j = 0; j < n - 1; j++) {
                int cur = Integer.parseInt(strArr[j]);
                int next = Integer.parseInt(strArr[j + 1]);
                if(cur != next){
                    isPossible = true;
                    break;
                }
            }
            if(isPossible){
                sb.append(1);
            }else{
                sb.append(n);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}