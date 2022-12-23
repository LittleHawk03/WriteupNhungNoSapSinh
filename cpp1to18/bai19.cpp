#include <bits/stdc++.h>

using namespace std;

bool check_prime(int n)
{
    if (n == 2)
    {
        return false;
    }
    if (n < 2 || n % 2 == 0)
    {
        return false;
    }
    int i = 3;
    int k = ceil(sqrt(n));
    while (i <= k)
    {
        if (n % i == 0)
        {
            return false;
        }
        i += 2;
    }
    return true;
}

void solution(int m, int l, int A, int B, int C)
{
    bool flag = false;
    for (int i = m; i <= l; i++)
    {
        long result = A * i * i + B * i + C;
        if (check_prime(result))
        {
            flag = true;
            cout << "so can tim la : " << i << endl;
        }
    }
    if (!flag)
    {
        cout << "khong co so nao " << endl;
    }
}

int main(int argc, char const *argv[])
{
    int m, l, A, B, C;
    cin >> m;
    cin >> l;
    cin >> A;
    cin >> B;
    cin >> C;

    solution(m, l, A, B, C);
    return 0;
}
