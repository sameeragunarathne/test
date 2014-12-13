

package fiverr1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Fiverr1 {

  	class MyReader {
		BufferedReader reader;
		StringTokenizer tokenizer;

		void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");

		}

		// get next word
		String next() throws IOException {

			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) throws Exception {

		// Scanner sc = new Scanner(System.in);

		// You may use the method below to use a sample input file for testing
		// instead of standard(keyboard)input
		// but before submission you need to comment it.

		// Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		System.setIn(new FileInputStream("/home/sameera/Downloads/sample_inputs/sensor.txt"));
		Fiverr1 A = new Fiverr1();
		MyReader R = A.new MyReader();
		R.init(System.in);
		int T = 0;
                
                Sensor2 newSensor=new Sensor2();
                
		// int T = sc.nextInt(); // T = number of test cases
		T = R.nextInt(); // number of test cases

		for (int test_case = 1; test_case <= T; test_case++) {

			// 1. Read input for each test case
			// 2. Call your functions
			// 3. Print the answer to standard output(screen).

			System.out.println("Case #" + test_case);
			// Print your answer
                        int a=R.nextInt();
                        int b=R.nextInt();
                        int k=R.nextInt();
                        
                        newSensor.f(a, b, k);
		}
	}
    
}
