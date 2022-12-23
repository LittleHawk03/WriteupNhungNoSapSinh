package Security;

import java.util.Scanner;

public class bai13 {
    /**
     * ta co :
     * a + b = c
     * a - b = d
     * 
     * tu bieu thuc ta co d + b = c - b kết hợp với điều kiện a lớn hơn 2 và a là số
     * nguyên tố
     * (luôn là số lẻ) nên c - b và d + b cũng phải là số lẻ . Mà theo yêu cầu thì
     * dcm c và d đều
     * là số nguyên tố => b phải là số chẵn (b cũng là số nguyên tố lun) => b = 2
     * việc còn lại là
     * tìm em tìm em trong bóng đêm ;
     */

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        System.out.println(" nhap so n : ");
        n = scanner.nextInt();
        /*
         * vì bài toán chỉ là tìm a để a + 2 và a - 2 là số nguyên tố
         * nên là ta lại tiến hành sàng
         */
        Boolean[] isPrime = new Boolean[n + 1];
        isPrime[1] = false;
        // gan gia tri cua tat ca phan tu cua mang la true
        for (int i = 2; i < n + 1; i++) {
            isPrime[i] = true;
        }

        // tien hanh sang so nguyen to
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        /**
         * đi tìm a nào mình sẽ chạy từ đầu đến cuối số nào thỏa mãn
         * a + 2 và a - 2 là số nt thì in ra
         */
        for (int i = 3; i <= n; i += 2) {
            if (isPrime[i]) {
                if (isPrime[i + 2] && isPrime[i - 2]) {
                    System.out.println(" hai so do la : [ " + i + " , " + 2 + " ]");
                }

            }

        }

    }

}
