package codeforces;

import java.io.*;

public class A_div2_0621 {
    private static int n = 0;
    private static int d = 0;
    private static int[] piles = null;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr1 = br.readLine().split(" ");
            String[] strArr2 = br.readLine().split(" ");
            n = Integer.parseInt(strArr1[0]); d = Integer.parseInt(strArr1[1]);
            piles = new int[n];
            for (int j = 0; j < n; j++) {
                piles[j] = Integer.parseInt(strArr2[j]);
            }
            sb.append(findMaxA1()).append("\n");
            n = 0; d = 0; piles = null;
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static int findMaxA1() {
        if(piles.length == 1){
            return piles[0];
        }
 
        int max = piles[0];
        int index = 1;
        while(d > 0 && index <= n - 1){
            int daysForRightsToLeft = index * piles[index];
            if(d > daysForRightsToLeft){
                max += piles[index];
                d -= daysForRightsToLeft;
            }else{
                int possibleNumsRightsToLeft = d / index;
                max += possibleNumsRightsToLeft;
                d -= (index * possibleNumsRightsToLeft);
            }
            index++;
        }
        return max;
    }
}
