package codeforces;

import java.io.*;
import java.util.Arrays;
 
public class B_div2_0618 {
    private static int n = 0;
    private static int[] arr = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2 * n];
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < 2 * n; j++) {
                arr[j] = Integer.parseInt(strArr[j]);
            }
            Arrays.sort(arr);
            sb.append(arr[n] - arr[n - 1]).append("\n");
            n = 0;
            arr = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
