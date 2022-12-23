#include <bits/stdc++.h>

using namespace std;

bool checkChinhPhuong(int n)
{
    int i = sqrt(n);
    return i * i == n;
}

int main()
{
    int n;
    cin >> n;

    bool is_prime[n + 1];

    memset(is_prime, true, n + 1);

    for (int i = 2; i * i <= n; i++)
    {
        if (is_prime[i])
        {
            for (int j = i * i; j <= n; j += i)
            {
                is_prime[j] = false;
            }
        }
    }

    for (int i = 2; i < n; i++)
    {
        if (checkChinhPhuong(i) && is_prime[(int)sqrt(i)])
        {
            cout << i << endl;
        }
    }

    return 0;
}