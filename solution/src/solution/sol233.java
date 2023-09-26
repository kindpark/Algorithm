package solution;

import java.io.*;
import java.util.*;

public class sol233 {

	static int n;
	static long[] tree,arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new long[n+1];
		tree = new long[getTreeSize()];
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(0, n-1, 1);
		while(true) {
			if(m==0 && k==0) break;
			
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if(op ==1) {
				int idx = Integer.parseInt(st.nextToken())-1;
				long num = Long.parseLong(st.nextToken());
				
				update(0, n-1, 1, idx, num);
				arr[idx] = num;
				
				m--;
			}else {
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken())-1;
				
				long sum =sum(0, n-1, 1, left, right);
				sb.append(sum+"\n");
				
				k--;
			}
		}
		
		System.out.println(sb.toString());
	}
    
    // Ʈ�� ������ ���ϱ�
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
		return (int)Math.pow(2, h)-1;
	}
	
    // �ʱⰪ ����
	static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;
		
		return tree[node] = (init(start, mid, node*2) * init(mid+1, end, node*2+1)) % 1000000007;
	}
	
	
    // Ʈ�� ����
	static long update(int start, int end, int node, int idx, long val) {
		if(start > idx || idx > end) {
			return tree[node];
		}
		
		if(start == end) 
			return tree[node] = val;
		
		int mid = (start+end)/2;
		return tree[node] = (update(start, mid, node*2, idx, val) * update(mid+1, end, node*2+1, idx, val)) % 1000000007;
		
	}
	
    // ���� �� ���ϱ�
	static long sum(int start, int end, int node, int l, int r) {
		
		if(r < start || l> end ) 
			return 1;
		if(l <= start && end <= r )
			return tree[node];
		
		int mid = (start+end)/2;
		
		return (sum(start, mid, node*2, l, r) * sum(mid+1, end, node*2+1, l, r)) % 1000000007;  
	}
}
