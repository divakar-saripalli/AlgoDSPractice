package src.com.div.missionfaang.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DownToZero {

    /*
     * Complete the downToZero function below.
     */
    static int downToZero(int n) {
	/*
	 * Write your code here.
	 */

	if(n < 4){
	    return n;
	}

	int count = 0;
	while(n >= 4){
	    if(isPrime(n)){
		n--;
	    }else{
		double dub = n;
		double sqrt = Math.sqrt(dub);
		int a = (int)sqrt;
		System.out.println(n);
		System.out.println(dub);
		System.out.println(sqrt);
		System.out.println(a);
		System.out.println("=======================================");
		for(int j=a; j<=n/2; j++){
		    if(j*j == n || n%j == 0) {
			n = j;
			System.out.println(j);
			break;
		    }
		    System.out.println(j);
		    System.out.println("-------------");
		}
		System.out.println("#####################################");
	    }
	    count++;
	}
	count += n;

	return count;
    }

    static boolean isPrime(int n)
    {
	// This is checked so that we can skip
	// middle five numbers in below loop
	if (n % 2 == 0 || n % 3 == 0)
	    return false;

	for (int i = 5; i * i <= n; i = i + 6)
	    if (n % i == 0 || n % (i + 2) == 0)
		return false;

	return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
	int q = Integer.parseInt(scanner.nextLine().trim());

	for (int qItr = 0; qItr < q; qItr++) {
	    int n = Integer.parseInt(scanner.nextLine().trim());
	    int result = downToZero(n);
	    System.out.println(result);
	}
    }
}

