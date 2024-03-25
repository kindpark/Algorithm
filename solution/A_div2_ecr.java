package codeforces;

import java.io.*;

public class A_div2_ecr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            char[] chArr = br.readLine().toCharArray();
            boolean isOneStart = false;
            boolean isNewOneVisible = false;
            int zeros = 0;
            int lastOneIndex = -1;
            int lastZeroIndex = -1;
            for (int j = 0; j < chArr.length; j++) {
                if(chArr[j] == '1'){
                    isOneStart = true;
                    lastOneIndex = j;
                }else{
                    if(isOneStart){
                        zeros++;
                    }
                    lastZeroIndex = j;
                }
            }
            if(lastZeroIndex == chArr.length - 1 && lastOneIndex != -1){
                zeros -= (lastZeroIndex - lastOneIndex);
            }
            sb.append(zeros).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
