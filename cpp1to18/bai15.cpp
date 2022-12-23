#include <bits/stdc++.h>

using namespace std;

// Câu 15. Viết chương trình Hai số nguyên tố sinh đôi là hai số nguyên tố hơn kém nhau 2 đơn vị.
// Tìm hai số nguyên tố sinh đôi nhỏ hơn hoặc bằng N, với N được nhập vào từ bàn phím.

int main(){

    int N;
    cin >> N;

    bool is_prime[N + 1];

    memset(is_prime, true, N + 1);

    for (int i = 2; i * i <= N; i++)
    {
        if (is_prime[i])
        {
            for (int j = i * i; j <= N; j += i)
            {
              
              is_prime[j] = false;
            }
        }
    }

    for (int i = 2; i <= N; i++)
    {
        if (is_prime[i] && is_prime[i + 2])
        {
            cout << " so thu 1 : " << i << " so thu 2 : " << i + 2 << endl;
        }
        
    }
    

    return 0;
}
