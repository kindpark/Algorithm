package codeforces;

import java.io.*;

public class A_div2_0625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] rArr = new int[n];
        int[] bArr = new int[n];
        String[] strArr1 = br.readLine().split(" ");
        String[] strArr2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            rArr[i] = Integer.parseInt(strArr1[i]);
            bArr[i] = Integer.parseInt(strArr2[i]);
        }
 
        boolean isPossible = true;
        int rNums = 0;
        int bNums = 0;
        for (int i = 0; i < n; i++) {
            if(rArr[i] != bArr[i]){
                if(bArr[i] == 1){
                    bNums++;
                }else{
                    rNums++;
                }
            }
        }
        int answer = 0;
        if(rNums > bNums){
            answer = 1;
        }else if(rNums == bNums){
            if(rNums == 0){
                isPossible = false;
            }else{
                answer = 2;
            }
        }else{
            if(rNums == 1){
                answer = 2 - rNums + bNums;
            }else{
                int minBSums = bNums;
                if(rNums == 0){
                    isPossible = false;
                }else{
                    answer = minBSums / rNums + 1;
                }
            }
        }
        if(!isPossible){
            sb.append(-1);
        }else{
            sb.append(answer);
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
