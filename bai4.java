package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai4 {
    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        int a,b;
        System.out.println("nhap a : ");
        a = scanner.nextInt();
        System.out.println("nhap b : ");
        b = scanner.nextInt();

        //khởi tạo mảng boolean với b -a + 1 phần tử
        Boolean[] isPrime = new Boolean[b - a + 1];
        // gán tất cả phần tử bằng true
        Arrays.fill(isPrime, true);
        // bát đầu sàng phân đoạn thế a , b để lọc các 
        for (int i = 2; i*i <= b; i++) {
            for (int j = Math.max(i*i, (a + i - 1) / i * i); j <= b; j+=i) {
                isPrime[j - a] = false;
            }
        }
        // trương hợp nếu a <= 1 thì phải gán faile
        if (a <= 1) {
            isPrime[1 - a] = false;
        }
        int dem = 0;
        // in ra các số nguyên tố
        for (int i = a; i <= b; i++) {
            if (isPrime[i - a]) {
                System.out.println("snt : " + i);
                dem++;
            }
        }
        System.out.println(" so luong so nguyen to trong khoang (" + a+"," + b + ") = " + dem);

    }
}
