
aa = "?��길동?��"
print("문제 1 : ?��#�?#?��#?��# 출력?���?")

for i in range(0,len(aa)) :
    print(aa[i],end="#")
print()
print("문제 2 : ?��?��길홍 출력?���?")
for i in range(-1,len(aa)*-1-1,-1) :
    print(aa[i],end="")
print()    
print(aa[::-1])
print()