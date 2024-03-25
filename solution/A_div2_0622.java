package codeforces;

import java.io.*;
import java.util.Arrays;
 
public class A_div2_0622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int c = Integer.parseInt(strArr[2]);
            sb.append(findMaxNums(a, b, c)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static int findMaxNums(int a, int b, int c) {
        if(a >= 4 && b >= 4 && c >= 4){
            return 7;
        }
        if(a >= 3 && b >= 3 && c >= 3){
            return 6;
        }
        int nums = 0;
        int[] arr = new int[3];
        arr[0] = a; arr[1] = b; arr[2] = c;
        Arrays.sort(arr);
        for (int i = 0; i < 3; i++) {
            if(arr[i] > 0){
                nums++;
                arr[i] = arr[i] - 1;
            }
        }
        for (int i = 2; i >= 0; i--) {
            if(arr[i] > 0 && arr[(i + 1) % 3] > 0){
                nums++;
                arr[i] = arr[i] - 1;
                arr[(i + 1) % 3] = arr[(i + 1) % 3] - 1;
            }
        }
        return nums;
    }
}
