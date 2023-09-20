package solution;

import java.io.*;
import java.util.*;

// ���� �� ���ϱ� ���� 2042
public class sol232{
	
	static int N, M, K;				// N ���� ����, M ���� ����, K ���� ����
	static int offset;				// �ε�����Ʈ���� ������ �Ǵ� ��ġ
	static long[] indexedTree;		// �ε�����Ʈ��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. �Է�
		// N, M, K �Է�
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// �ε�����Ʈ�� ũ�� Ư�� �� ����   (offset�� N���� ũ�ų� ����, ������ 2^N)
		for (offset=1; offset<N; offset*=2);	
		indexedTree = new long[offset*2+2];
		
		// �ε�����Ʈ���� ������ �Է�			- Ʈ�� �ϴܿ� 1~N�� ���� ���� ���� �Է�
		for (int i=0; i<N; i++) {
			indexedTree[offset+i] = Long.parseLong(br.readLine());
		}
		// 2. ������ ������ �������			- �ؿ������� �����͸� �׾ƿø�, [1] �� root
		for(int i=offset-1; i>=1; i--) {
			indexedTree[i] = indexedTree[i*2]+indexedTree[i*2+1];
		}
		
		int size = M + K;			// ����� ������ ���� �ݺ��� ũ��� ����
		for (int i=1; i<=size; i++) {
			int type, x;
			long y;		
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());		// 1�̸� edit, 2�̸� ����
			x = Integer.parseInt(st.nextToken());			// type=1 �ٲ� �� / type=2 startId
			y = Long.parseLong(st.nextToken());			// type=1 ���氪 / type=2 endId
			
			if (type==1) {
				update(x-1,y);
			}
			else {
				int endId;
				endId = (int)y;
				bw.write(String.valueOf(sum(x-1, endId-1))+"\n");				
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	// �ε�����Ʈ�� ���� 1) �ش� id �� ���� 2) ���� �ö󰡸鼭 �� ���� -> logN�� �ð����⵵
	static void update(int id, long value) {
		int x = id + offset;
		// �ε�����Ʈ�� ��ġ�� value�� ���� �����
		indexedTree[x] = value;
		while(x>0) {
			x /=2;
			indexedTree[x] = indexedTree[x*2] + indexedTree[x * 2 + 1];
		}
		return;
	}
	
	// �ε�����Ʈ�� �� ���ϱ� ���� �ö󰡸鼭 �� ���ϱ�
	static long sum(int start, int end) {
		int l = start + offset;
		int r = end + offset;
		long ret = 0;
		while(l<=r) {
			if ((l & 1) == 1) ret += indexedTree[l++];	// ���� id�� Ȧ���̸� ���� Ƣ�Ƿ� �����ְ� l++ ���� (¦������ �����ؾ��ϴϱ�)
			if ((r & 1) == 0) ret += indexedTree[r--];	// ������ id�� ¦���̸� ���� Ƣ�Ƿ� �����ְ� r-- ���� (Ȧ���� �������ϴϱ�)
			l/=2;	// ���� �ö󰡱�
			r/=2;	// ���� �ö󰡱�
		}
		return ret;
	}
}
