import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();
		int [] arr = new int [9];
		for(int i = 0; i<n.length(); i++) {
			int num = n.charAt(i) - '0';
			if (num == 6) {
				arr[9]++;
			}else{
				arr[num]++;
			}
		}

		int max = 0;
		for(int i = 0; i<9; i++) {
			max = Math.max(max, arr[i]);
		}
		int nine = arr[9]/2;
		if (arr[9] % 2 == 1) {
			nine++;
		}
		max = Math.max(max, nine);
		System.out.println(max);
	}
}
