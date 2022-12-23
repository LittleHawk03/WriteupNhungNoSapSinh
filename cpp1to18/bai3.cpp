#include <bits/stdc++.h>

using namespace std;

// . Cho một số nguyên dương N, gọi:
// - k là số ước nguyên tố của N;
// - q là tổng của các ước nguyên tố của N;
// - p là tổng của các ước số của N;
// - s là số ước của N;
// Hãy viết chương trình tính giá trị của: N+p+s-q-k với N cho trước nhập từ bàn phím.

int main()
{

    int N, k, q, p, s;
    k = q = 0;
    p = s = 1;

    cin >> N;

    bool hash[N + 1];

    memset(hash, true, sizeof(hash));

    // sang tim so nguyen to
    for (int i = 2; i * i <= N; i++)
    {
        if (hash[i])
        {
            for (int j = i * i; j <= N; j += i)
            {
                hash[j] = false;
            }
        }
    }

    

    // tim k va q
    for (int i = 2; i <= N; i++)
    {
        if (hash[i] && N % i == 0)
        {
            q = q + i;
            k++;
        }
    }

    // cout << q << endl;
    // cout << k << endl;

    // tim p va s

    for (int i = 2; i * i <= N; i++)
    {
        if (N % i == 0)
        {
            if ((N / i) == i)
            {
                p = p + i;
                s++;
            }
            else
            {
                p = p + (i + N / i);
                s += 2;
            }
        }
    }

    // uoc so la chinh no 
    p =  p + N;
    s = s + 1;

    // cout << p << endl;
    // cout << s << endl;

    cout << N + p + s - q - k << endl;
    return 0;
}