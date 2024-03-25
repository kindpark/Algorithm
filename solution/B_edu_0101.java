package codeforces;

import java.io.*;
import java.util.Arrays;
 
public class B_edu_0101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] strArr1 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    a[j] = Integer.parseInt(strArr1[j]);
                }else{
                    a[j] = a[j - 1] + Integer.parseInt(strArr1[j]);
                }
            }
            int m = Integer.parseInt(br.readLine());
            int[] b = new int[m];
            String[] strArr2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if(j == 0){
                    b[j] = Integer.parseInt(strArr2[j]);
                }else{
                    b[j] = b[j - 1] + Integer.parseInt(strArr2[j]);
                }
            }
            Arrays.sort(a);
            Arrays.sort(b);
            if(a[n - 1] < 0 && b[m - 1] < 0){
                sb.append(0);
            }else if(a[n - 1] >= 0 && b[m - 1] < 0){
                sb.append(a[n - 1]);
            }else if(a[n - 1] < 0 && b[m - 1] >= 0){
                sb.append(b[m - 1]);
            }else{
                sb.append(a[n - 1] + b[m - 1]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
