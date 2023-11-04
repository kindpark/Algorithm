package atcoder;

import java.util.Scanner;
import java.io.*;
import java.math.*;
public class sol5 {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	long a = 0;
    	long sum = 1;
    	long b = Long.parseLong(br.readLine());
    	for(int i = 1; i < 20; i++) {
    		sum =1;
    		for(int j = 1; j <= i; j++) {
    			sum *= i;
    		}
    		if(b == sum) {
    			System.out.println(i);
    			break;
    		}
    		else if(sum > b){
    			System.out.println(-1);
    			break;
    		}
    	}
    }
}
