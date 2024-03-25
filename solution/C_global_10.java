package codeforces;

import java.io.*;

public class C_global_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().split(" ");
            int prev = Integer.parseInt(strArr[0]);
            long sum = 0;
            for (int j = 1; j < n; j++) {
                int current = Integer.parseInt(strArr[j]);
                if(prev > current){
                    sum += (prev - current);
                }
                prev = current;
            }
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
