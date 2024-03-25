package codeforces;

import java.io.*;
import java.util.ArrayList;
 
public class B_div2_0625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] bv = new int[n + 1];
        String[] strArr = br.readLine().split(" ");
        long max = 0;
        for (int i = 0; i < n; i++) {
            bv[i + 1] = Integer.parseInt(strArr[i]);
            if(max < bv[i + 1]){
                max = bv[i + 1];
            }
        }
 
        ArrayList<ArrayList<Integer>> setList = new ArrayList<>();
 
        boolean[] contains = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            if(!contains[i]){
                contains[i] = true;
                ArrayList<Integer> newSet = new ArrayList<>();
                newSet.add(i);
                for (int j = i + 1; j <= n; j++) {
                    if(j - i == bv[j] - bv[i]){
                        newSet.add(j);
                        contains[j] = true;
                    }
                }
                setList.add(newSet);
            }
        }
 
        for (int i = 0; i < setList.size(); i++) {
            long tmp = 0;
            ArrayList<Integer> tmpSet = setList.get(i);
            for (int j = 0; j < tmpSet.size(); j++) {
                tmp += bv[tmpSet.get(j)];
            }
            if(tmp > max){
                max = tmp;
            }
        }
 
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
