#include <bits/stdc++.h>

using namespace std;

int countDir(int n)
{
    bool is_prime[n + 1];

    int e = 0;

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

    int total = 1;

    for (int i = 2; i <= n; i++)
    {
        if (is_prime[i])
        {
            int count = 0;
            if (n % i == 0)
            {
                while (n % i == 0)
                {
                    n = n / i;
                    count++;
                }
                total = total * (count + 1);
            }
        }
    }

    return total;
}

int main()
{

    int n;
    cin >> n;

    for (int i = 0; i <= n; i++)
    {
        if (countDir(i) == 4)
        {
            cout << "i : " << i << endl;
        }
    }
    cout << endl;

    return 0;
}