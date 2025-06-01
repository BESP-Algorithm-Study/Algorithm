import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int result = a * b * c;

		int[] arr = new int[10];
		String str = Integer.toString(result);

		for (
			int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			arr[ch - 48]++;
		}

		for (
			int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}
