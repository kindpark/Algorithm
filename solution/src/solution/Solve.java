package solution;

import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
public class Solve {
	static LinkedList<Integer>[] ar;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		ar = new LinkedList[100];
		for(int i = 0; i < 100; i++) {
			ar[i] = new LinkedList<>();
		}
		int [][] ap = new int[3][3];
		System.out.println(ap[1][1]);
	}
}