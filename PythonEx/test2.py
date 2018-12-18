'''
test2.py : 자료형
변수 선언이 가능하지만 필요 없다. 하지만 변수를 미리 선언하는 것이 더 효율적.


@author: gdj-4
'''
from ctypes.wintypes import DOUBLE
a=100
b=50
#a,b = 100,50 (이와 같은 형태로 변수 선언 가능)
print("""a+b=""",a+b)
print(type(a))

#콘솔에서 입력받아 a 변수에 저장하기
a = int(input("첫번째숫자"))
b = int(input("두번째숫자"))
result = a+b
print(a,"+",b,"=",result)
result = a-b
print(a,"-",b,"=",result)
result = a*b
print(a,"*",b,"=",result)
result = a/b
print(a,"/",b,"=",result)
result = a%b
print(a,"%",b,"=",result)

# ** : 제곱
# // : 몫(나누기 이후에 소수점 제거)

print("9**2",a//b)
print("9의 제곱",9**2,", 나누기 정수값:",a//b)
print("a"+"b"+"c")
print("abc"*3)