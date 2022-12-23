#include <bits/stdc++.h>

using namespace std;

// Câu 16. Viết chương trình tìm các số nguyên tố từ một mảng sinh ngẫu nhiên có kích thước N,
// với N nhập vào từ bàn phím.
bool check(int n)
{
    if (n == 2)
    {
        return false;
    }

    if (n < 2 || n % 2 == 0)
    {
        return false;
    }

    int i = 2;

    int k = ceil(sqrt(n));

    while (i <= k)
    {
        if (n % i == 0)
        {
            return false;
        }
        i++;
    }

    return true;
}

int main()
{

    int N;
    cin >> N;

    int a[N + 1];

    cout << rand() % 20 + 1 << endl;

    for (int i = 0; i < N; i++)
    {
        a[i] = rand() % N + 1;
    }

    cout << " day so sinh ngau nhien : ";

    for (int i = 0; i < N; i++)
    {
        cout << a[i] << " ";
    }

    cout << endl;

    cout << " day so nguyen to la : ";

    for (int i = 0; i < N; i++)
    {

        if (check(a[i]))
        {
            cout << a[i] << " ";
        }
    }

    cout << endl;
    return 0;
}