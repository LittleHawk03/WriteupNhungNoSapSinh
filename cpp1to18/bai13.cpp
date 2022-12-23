#include <bits/stdc++.h>

using namespace std;

// Viết chương trình tìm hai số nguyên tố nhỏ hơn hoặc bằng N với N nhập vào từ bàn
// phím, sao cho tổng và hiệu của chúng đều là số nguyên tố.

int main(){

    int N;

    cin >> N;
    bool is_prime[N + 4];

    memset(is_prime,true,N+1);
    is_prime[1] = false;

    for (int i = 2; i*i <= N + 4; i++)
    {
        if (is_prime[i])
        {
            for (int j = i*i; j <= N + 4; j+=i)
            {
                is_prime[j] = false;
            }
            
        }
        
    }
    
    /**
     * ta co :
     * a + b = c
     * a - b = d
     * 
     * tu bieu thuc ta co d + b = c - b kết hợp với điều kiện a lớn hơn 2 và a là số nguyên tố  
     * (luôn là số  lẻ) nên c - b và d + b cũng phải là số lẻ . Mà theo yêu cầu thì dcm c và d đều
     * là số nguyên tố  => b phải là số chẵn (b cũng là số nguyên tố lun) => b = 2 việc còn lại là 
     * tìm em tìm em trong bóng đêm ;
     */
   
    for (int i = 3; i <= N; i+=2)
    {
        if (is_prime[i])
        {
           if (is_prime[i + 2] && is_prime[i - 2])
           {
                cout << " hai so a , b la : " << i << " , " << 2 << endl;
           }
           
        }
        
    }
    
    

    return 0;
}