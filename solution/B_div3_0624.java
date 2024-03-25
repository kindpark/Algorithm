package codeforces;

import java.io.*;
import java.util.Arrays;
 
public class B_div3_0624 {
    private static int n = 0;
    private static int m = 0;
    private static int[] a = null;
    private static int[] p = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr1 = br.readLine().split(" ");
            String[] strArr2 = br.readLine().split(" ");
            String[] strArr3 = br.readLine().split(" ");
            n = Integer.parseInt(strArr1[0]);
            m = Integer.parseInt(strArr1[1]);
            a = new int[n + 1];
            p = new int[m];
            for (int j = 1; j <= n; j++) {
                a[j] = Integer.parseInt(strArr2[j - 1]);
            }
            for (int j = 0; j < m; j++) {
                p[j] = Integer.parseInt(strArr3[j]);
            }
 
            sb.append(isPossible()).append("\n");
 
            n = 0; m = 0; a = null; p = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static String isPossible() {
        String answer = "YES";
        Arrays.sort(p);
 
        int startIndex = -1;
        int endIndex = -1;
        int i;
        for (i = 1; i <= n - 1; i++) {
            if(a[i] > a[i + 1]){
                if(startIndex == -1) {
                    startIndex = i;
                }
            }else{
                if(startIndex != -1){
                    endIndex = i;
                    for (int j = startIndex; j < endIndex; j++) {
                        if(Arrays.binarySearch(p, j) < 0){
                            answer = "NO";
                            break;
                        }
                    }
                    if(answer.equals("NO")){
                        break;
                    }
                    Arrays.sort(a, startIndex, endIndex);
                    while(startIndex != 0 && a[startIndex - 1] > a[startIndex]){
                        if(Arrays.binarySearch(p, startIndex - 1) < 0){
                            answer = "NO";
                            break;
                        }else{
                            int tmp = a[startIndex - 1];
                            a[startIndex - 1] = a[startIndex];
                            a[startIndex] = tmp;
                            startIndex--;
                        }
                    }
                    if(a[endIndex] > a[endIndex + 1]){
                        i = endIndex - 1;
                    }
                    startIndex = -1;
                    endIndex = -1;
                }
            }
        }
        if(startIndex != -1){
            endIndex = n;
            for (int j = startIndex; j < endIndex; j++) {
                if(Arrays.binarySearch(p, j) < 0){
                    answer = "NO";
                    break;
                }
            }
        }
 
        return answer;
    }
}
