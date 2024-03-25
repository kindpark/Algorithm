package codeforces;

import java.io.*;

public class B_0654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int r = Integer.parseInt(strArr[1]);
            sb.append(solution(n, r)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static long solution(int n, int r) {
        long answer = 0;
 
        long min = Math.min(n, r);
        if(min == n){
            answer = (min * (min - 1)) / 2 + 1;
        }else{
            answer = min * (min + 1) / 2;
        }
 
        return answer;
    }
 
}
