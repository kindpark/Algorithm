package codeforces;

import java.io.*;

public class B_global_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            long k = Long.parseLong(nk[1]);
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            String[] strArr = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(strArr[j]);
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
            }
 
            for (int j = 0; j < n; j++) {
                nums[j] = max - nums[j];
            }
 
            if(k % 2 == 1){
                for (int j = 0; j < n; j++) {
                    sb.append(nums[j]).append(" ");
                }
            }else{
                for (int j = 0; j < n; j++) {
                    sb.append((max - min) - nums[j]).append(" ");
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
