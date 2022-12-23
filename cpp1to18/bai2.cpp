#include <bits/stdc++.h>
#include <math.h>
using namespace std;

int main()
{
    int n, a, b, t;

    cin >> n;

    a = pow(10, n - 1);
    b = pow(10, n) - 1;

    cout << a << endl;
    cout << b << endl;

    bool hash[b];

    memset(hash, true, b - a + 1);

    for (int i = 2; i * i <= b; i++)
    {
        for (int j = max(i * i, (a + i - 1) / i * i); j <= b; j += i)
        {
            hash[j - a] = false;
        }
    }

    if (a <= 1)
    {
        hash[1 - a] = false;
    }

    for (int i = a; i <= b; i++)
    {
        if (hash[i - a])
        {
            cout << i << " ";
        }
    }

    cout << endl;

    return 0;
}