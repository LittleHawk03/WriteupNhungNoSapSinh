package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai8ver2 {
    static Scanner scanner = new Scanner(System.in);


    /***
     * hơi khó hiểu tẹo nhưng theo cái công thứ số ước bằng tích của các số mũ cộng 1
     * thì để có 3 ước thì số đó phải là bình ohuwong của 1 số nguyên tố 
     * ví du 25 là 5 ^ 2 thi số ước sẽ là (2 + 1 =  3) : 1 5 25 
     * 
    */

    public static Boolean checkChinhPhuong(int n) {
        int i = (int) Math.sqrt(n);
        return i*i == n;
    }

    public static void main(String[] args) {
        int n;
        System.out.println(" nhap N : ");
        n = scanner.nextInt();

        Boolean[] isPrime = new Boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[(int) Math.sqrt(i)] && checkChinhPhuong(i)) {
                System.out.println(" i : " + i);
            }
        }
    }
}
