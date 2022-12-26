package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai44 {
    
    static Scanner scanner = new Scanner(System.in);

    
    public static void ScannerArray(int n, int[] arr,int p) {
        System.out.println("nhap cac phan tu sao cho p va phan tu do co uoc chung la 1");
        for (int i = 0; i < n; i++) {
            System.out.println("a[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }
    }

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
        while (x2 < 0) {
            x2 = x2 + p;
        }

        return x2;
    }

    public static void printArray(int[] arr,int n) {
        System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        int p,n;
        System.out.println("nhap so p : ");
        p = scanner.nextInt();
        System.out.println("nhap so luong phan tu : ");
        n = scanner.nextInt();
        int[] arr = new int[n + 1];
        ScannerArray(n, arr, p);
        printArray(arr, n);
        int[] arr2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr2[i] = extend_Euclide(arr[i], p);
        }
        printArray(arr2, n);
    }
}
