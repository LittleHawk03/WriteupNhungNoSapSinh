# Câu 19. Viết chương trình in ra các số nguyên dương x nằm trong khoảng [m,l] sao cho giá trị
# của biểu thức 𝐴𝑥 2 + 𝐵𝑥 + 𝐶 là một số nguyên tố. Với A,B,C, m,l là các số nguyên nhập từ bàn
# phím (m<l).

def check_prime(n):
    if n == 2:
        return True
    if n < 2 or n % 2 == 0:
        return False
    i = 3
    while i*i <= n:
        if n % i == 0:
            return False
        i = i + 2

    return True


def solution(m, l, A, B, C):
    
    flag = False
    for i in range(m, l + 1):
        result = A * i * i + B * i + C
        if check_prime(result):
            flag = True
            print("so can tim la : " + str(i) + " va tong Ax^2 + Bx + C : " + str(result))
    if not flag:
        print("khong co so nao")

if __name__ == '__main__':
    A = int(input('A : '))
    B = int(input('B : '))
    C = int(input('C : '))
    m = int(input('m : '))
    l = int(input('l : '))
    solution(m, l, A, B, C)
    print("ket thuc")
