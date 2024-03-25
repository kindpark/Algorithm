package codeforces;

import java.io.*;

public class A_edu_0101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            char[] chArr = br.readLine().toCharArray();
            boolean isPossible = true;
            if(chArr[0] == ')'){
                isPossible = false;
            }
            if(chArr[chArr.length - 1] == '('){
                isPossible = false;
            }
            if(chArr.length % 2 == 1){
                isPossible = false;
            }
            if(isPossible){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}