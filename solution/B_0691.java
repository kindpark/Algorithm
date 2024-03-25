package codeforces;

import java.util.Scanner;

public class B_0691 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if(n % 2 == 0){
            int sqrt = n / 2 + 1;
            System.out.println(sqrt * sqrt);
        }else{
            int param = n / 2;
            int sum = 4;
            int start = 8;
            int diff = 4;
            for (int i = 0; i < param; i++) {
                sum += start;
                start += diff;
            }
            System.out.println(sum);
        }
    }
}