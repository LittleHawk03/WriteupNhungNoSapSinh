
def Eratosthenes(a , b):
    isPrime = [True] * (b - a + 1)
    for i in range(2 , int(b**(1/2)) + 1):
        for j in range(max(i*i,((a + i - 1) // i)*i), b + 1,i):
            isPrime[j - a] = False
    if a <= 1:
        isPrime[1 - a] = False
    if a == 0:
        isPrime[0] = False
    
    for i in range(a,b):
        if isPrime[i - a]:
            print(i , end= " ")
    print("")
    return isPrime
                

def main():
    a = int(input())
    b = int(input())
    isPrime = Eratosthenes(a, b)
    s1 = []
    s2 = []
    for i in range(1,int(b**(1/2)) + 1):
        s1.append(i*i)
        s2.append(i*i)
    
    for i in range(1,len(s1)):
        for j in range(1,len(s2)):
            tong = s1[i] + s2[j]
            if tong >= a and tong <= b:
                if isPrime[tong - a]:
                    print("(s1 , s2) = (" + str(s1[i]) + "," + str(s2[j]) +")")
                       
if __name__ == '__main__':
    main()
    