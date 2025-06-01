import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(
			new InputStreamReader(System.in)
		);

		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i< n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int sum = Integer.parseInt(br.readLine());

		int start = 0;
		int end = n - 1;
		int count = 0;
		while(start < end) {
			int currentSum = arr[start] + arr[end];
			if(currentSum == sum) {
				count++;
				start++;
				end--;
			} else if(currentSum < sum) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(count);
	}
}
