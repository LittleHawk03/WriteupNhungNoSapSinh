package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai2 {
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhap n bieu cho n chu so : ");
        int n = scanner.nextInt();
        int a , b;

        // a ,b là 2 chốt của 1 số có n chư số
        // neu n = 2 thì a = 10 , b = 99
        a = (int) Math.pow(10, n - 1);
        b = (int) Math.pow(10, n) - 1;

        //khởi tạo mảng boolean với b -a + 1 phần tử
        Boolean[] isPrime = new Boolean[b - a + 1];
        // gán tất cả phần tử bằng true
        Arrays.fill(isPrime, true);
        // bát đầu sàng phân đoạn thế a , b
        for (int i = 2; i*i <= b; i++) {
            for (int j = Math.max(i*i, (a + i - 1) / i * i); j <= b; j+=i) {
                isPrime[j - a] = false;
            }
        }
        // trương hợp nếu a <= 1 thì phải gán faile
        if (a <= 1) {
            isPrime[1 - a] = false;
        }
        // in ra các số nguyên tố
        for (int i = a; i <= b; i++) {
            if (isPrime[i - a]) {
                System.out.print(i + " ");
            }
        }
    }
}
