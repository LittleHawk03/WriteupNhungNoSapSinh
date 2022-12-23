package Security;

import java.util.Scanner;

public class bai38 {
    
    static Scanner scanner = new Scanner(System.in);

    private static int extend_Euclide(int n, int p) {
        int x2 = 1, x1 = 0, y2 = 0, y1 = 1;
        int a = n,b = p;
        while (b > 0) {
            // 𝑞 ← 𝑎/𝑏 , 𝑟 ← 𝑎 − 𝑞𝑏, 𝑥 ← 𝑥2 − 𝑞𝑥1 , 𝑦 ← 𝑦2 − 𝑞𝑦1
            int q = a / b;
            int r = a % b;
            int x = x2 - q * x1;
            int y = y2 - q * y1;
            // 𝑎 ← 𝑏, 𝑏 ← 𝑟, 𝑥2 ← 𝑥1 , 𝑥1 ← 𝑥, 𝑦2 ← 𝑦1 , 𝑦1 ← 𝑦
            a = b;
            b = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;
        }

        // truong hop x2 nho hon 0 cong voi b den khi duong thi thoi
        // while (x2 < 0) {
        //     x2 = x2 + p;
        // }

        return x2;
    }

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int p = scanner.nextInt();
        System.out.println(extend_Euclide(a, p));
    }
}
