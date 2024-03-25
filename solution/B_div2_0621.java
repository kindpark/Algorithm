package codeforces;

import java.io.*;
import java.util.Arrays;
 
public class B_div2_0621 {
    private static int n = 0;
    private static int x = 0;
    private static int[] favorites = null;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr1 = br.readLine().split(" ");
            String[] strArr2 = br.readLine().split(" ");
            n = Integer.parseInt(strArr1[0]); x = Integer.parseInt(strArr1[1]);
            favorites = new int[n];
            for (int j = 0; j < n; j++) {
                favorites[j] = Integer.parseInt(strArr2[j]);
            }
            sb.append(findMinHops()).append("\n");
            n = 0; x = 0; favorites = null;
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static int findMinHops() {
        int minHops = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(x < favorites[i]){
                minHops = Math.min(minHops, 2);
            }else if(x == favorites[i]){
                minHops = Math.min(minHops, 1);
                break;
            }else{ // x > favorites[i]
                int hops = x / favorites[i];
                int rest = x % favorites[i];
                if(rest == 0){
                    minHops = Math.min(minHops, hops);
                }else{
                    minHops = Math.min(minHops, hops + 1);
                }
            }
        }
        return minHops;
    }
}

