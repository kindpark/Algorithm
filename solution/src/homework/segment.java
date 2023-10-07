package homework;
import java.io.*;
import java.util.StringTokenizer;

public class segment {
	//n = ���� ����
	static int n = 6, m;
	static int[] tree,arr;
	static boolean change = true;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������ Ƚ�� �ۼ�");
		StringTokenizer st = new StringTokenizer(br.readLine());
		//���� ������ �Ͼ�� Ƚ��
		m = Integer.parseInt(st.nextToken());
		//������ ���� ���ϴ� Ƚ��
		
		arr = new int[n+1];
		tree = new int[getTreeSize()];
		System.out.print("�迭 �Է�. 6�ڸ�");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//�������� �迭�� ���׸�Ʈ Ʈ���� ����
		init(0, n-1, 1);
		
		while(true) {
			if(m==0) break;
			System.out.print("���� 1 ��� 2");
			int change = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			if(change == 1) {
				//Ʈ�� �迭�� 0���� �����ϹǷ� �׿� �°� �� ����
				
				int index = Integer.parseInt(st.nextToken())-1;
				int num = Integer.parseInt(st.nextToken());		
				int different = num - arr[index];
				update(0, n-1, 1, index, different);
				
				arr[index] = num;
				m--;
			}else {
				//��
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken())-1;			
				int sum =segmentSum(0, n-1, 1, left, right);
				System.out.println(sum);
				m--;
			}
		}
		
		//System.out.println(sb.toString());
	}
    
    // Ʈ�� ������ ���ϱ�
	static int getTreeSize() {
		//2^-1 ���� �����ϴ� Ʈ���� ���
		int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
		return (int)Math.pow(2, h)-1;
	}
    // �ʱⰪ ����
	static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;		
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
    
	static void update(int start, int end, int node, int index, long different) {
		if(start <= index && index <= end) {
			tree[node] += different;
		}else {
			return;		
		}
		if(start == end) {
			return;
		}
		int mid = (start+end)/2;
		update(start, mid, node*2, index, different);
		update(mid+1, end, node*2+1, index, different);
		
	}
	
    // ���� �� ���ϱ�
	static int segmentSum(int start, int end, int node, int l, int r) {	
		if(r < start || l> end ) {
			return 0;
		}
		if(l <= start && end <= r ) {
			return tree[node];
		}
		int mid = (start+end)/2;	
		return segmentSum(start, mid, node*2, l, r) + segmentSum(mid+1, end, node*2+1, l, r);  
	}
}
