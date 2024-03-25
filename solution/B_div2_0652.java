package codeforces;

import java.io.*;

public class B_div2_0652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int length = Integer.parseInt(br.readLine());
            char[] chArr = br.readLine().toCharArray();
            sb.append(clear(length, chArr)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static String clear(int length, char[] chArr) {
        if(length == 1){
            return String.valueOf(chArr);
        }
        int start = length;
        int end = -1;
        for (int i = 0; i < length; i++) {
            if(chArr[i] == '1'){
                start = i;
                break;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if(chArr[i] == '0'){
                end = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start; i++) {
            sb.append(chArr[i]);
        }
        if(start < end){
            sb.append(0);
        }
        for (int i = end + 1; i < length; i++) {
            sb.append(chArr[i]);
        }
        return sb.toString();
    }
}

