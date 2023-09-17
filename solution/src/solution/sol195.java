package solution;

import java.util.*;
//2022-4
public class sol195 {
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		int[] seq = new int[N];
		int[] LIS = new int[N];
 
 
		for (int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
		LIS[0] = seq[0];
		int lengthOfLIS = 1;
		
		for (int i = 1; i < N; i++) {
			int key = seq[i];
			if (LIS[lengthOfLIS - 1] < key) {
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = key;
			} 
			else {
				int lo = 0;
				int hi = lengthOfLIS;
				while (lo < hi) {
					int mid = (lo + hi) / 2;
					
					if(LIS[mid] < key) {
						lo = mid + 1;
					}
					else {
						hi = mid;
					}
 
				}
				
				LIS[lo] = key;
			
			}
			
		}
		System.out.println(lengthOfLIS);
	}
}
