package TIL_Algorithm.my_0813;

/**
 * Main_sosu
 */
// 에라토스테네스의 체
public class Main_sosu {
    public static void main(String[] args) {
        boolean[] arr = new boolean[1000 + 1];
		for (int i = 2; i < arr.length; i++) {
			if (!arr[i]) {
				for (int j = i+1; j < arr.length; j++) {
					if (!arr[j] && j % i == 0) {
						arr[j] = true;
					}
				}				
			}
		}
        
    }
    
}