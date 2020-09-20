package my_0920;

public class Main_UnionSet {

	static int[] parents, ranks;
	static int N;

	public static void main(String[] args) {
		N = 10;
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) {	// �̹� ���� Ʈ��
			return;
		}
		
		// ���̰� �� ���� Ʈ���� ���ϱ�
		if (ranks[px] < ranks[py]) {
			parents[px] = py;
		} else {
			parents[py] = px;
			if (ranks[px] == ranks[py]) {
				ranks[px] += 1;
			}
		}
	}
}
