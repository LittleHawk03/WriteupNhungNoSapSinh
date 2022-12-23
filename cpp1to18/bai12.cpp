// Câu 12. Viết chương trình tìm bốn số nguyên tố liên tiếp, sao cho tổng của chúng là số nguyên tố
// nhỏ hơn hoặc bằng N (với N được nhập vào từ bàn phím).

#include <bits/stdc++.h>

using namespace std;

int main(){

    int N;
    long long sum = 0;

    cin >> N;

    bool prime[N + 1];

    memset(prime, true, N + 1);

    for (int i = 2; i * i <= N; i++)
    {
        if (prime[i])
        {
            for (int j = i * i; j <= N; j += i)
            {
                prime[j] = false;
            }
        }
    }

    vector<int> a;
    for (int i = 2; i <= N; i++)
    {
        if (prime[i])
        {
            a.push_back(i);
        }
        
    }

    for (int i = 0; i < a.size() - 4; i++)
    {
        int tong = a[i] + a[i + 1] + a[i + 2] + a[i + 3];
        if (tong <= N && prime[tong])
        {
            cout << a[i] << " " << a[i + 1] << " " << a[i + 2] << " " << a[i + 3] << endl;      
        }  
        // cout << a[i] << " ";
    }
    
    

    return 0;
}