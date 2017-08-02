import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	int min = 65;
	int max = 123;

	private boolean isPresent(int a[], int b[]) {
		for (int i = min; i < max; i++) {
			if (a[i] != b[i])
				return false;

		}
		return true;

	}

	public boolean isSubString(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();
		if (n < m)
			return false;
		if (m == 0)
			return true;

		// converting Strings to lowercase
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		// countArrays to keep track of frequency of characters in the window
		int count_main[] = new int[123];
		int count_aux[] = new int[123];
		
		for (int i = 0; i < m; i++)

		{
			count_main[s1.charAt(i)]++;

			count_aux[s2.charAt(i)]++;

		}

		for (int i = m; i < n; i++) {
			if (isPresent(count_main, count_aux))
				return true;
			count_main[s1.charAt(i - m)]--;
			count_main[s1.charAt(i)]++;

		}
		// explicitly checking for the final window
		if (isPresent(count_main, count_aux))
			return true;

		return false;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 0; tt < t; tt++) {
			String s1 = sc.next();
			String s2 = sc.next();

			Solution s = new Solution();

			if (s.isSubString(s1, s2))
				System.out.println("True");
			else
				System.out.println("False");
		}
		

	}

}
