package codeforces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class A_div2_0618 {
    private static int n = 0;
    private static int[] arr = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            String[] strArr = br.readLine().split(" ");
            List<Integer> zeroIndex = new ArrayList<>();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(strArr[j]);
                sum += arr[j];
                if(arr[j] == 0){
                    zeroIndex.add(j);
                }
            }
            sb.append(findMinSteps(sum, zeroIndex)).append("\n");
            n = 0;
            arr = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static int findMinSteps(int sum, List<Integer> zeroIndex) {
        if(sum != 0 && zeroIndex.isEmpty()){
            return 0;
        }
        if(sum == 0 && zeroIndex.isEmpty()){
            return 1;
        }else if(sum == 0 && !zeroIndex.isEmpty()){
            return zeroIndex.size();
        }else{// sum != 0 && !zeroIndex.isEmpty()
            if(sum + zeroIndex.size() == 0){
                return zeroIndex.size() + 1;
            }else{
                return zeroIndex.size();
            }
        }
    }
}

