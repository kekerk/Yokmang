
aa = "홍길동전"
print("문제 1 : 홍#길#동#전# 출력하기")

for i in range(0,len(aa)) :
    print(aa[i],end="#")
print()
print("문제 2 : 전동길홍 출력하기")
for i in range(-1,len(aa)*-1-1,-1) :
    print(aa[i],end="")
print()    
print(aa[::-1])
print()