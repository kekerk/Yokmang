'''
Created on 2018. 12. 20.

@author: gdj4

exam18.py : 0과 1부터 시작하는 피보나치 수열 구하기

0,1,1,2,3,5,8,13,21....

입력값 : 5
   0,1,1,2,3
   
입력값 : 10
   0,1,1,2,3,5,8,13,21,34
'''
fibolist = []
num = int(input("입력값 : "))
def fibo(num):
    global fibolist
    global num1, num2,num3 
    if num > 0 :
        fibolist.append(num1)
        num3 = num1
        num1 = num2
        num2 = num1 + num3
        num -= 1
        fibo(num)
    else :
        return
    
num1,num2,num3 = 0,1,1
fibo(num)
print("f(",num,") = ",end =' ')
print(fibolist)
arr = []
def fibonacci(num):
    a,b=0,1
    arr.append(0)
    for i in range(0,num-1) :
        a,b = b,a+b
        arr.append(a)
    return arr
s= fibonacci(num)
print(s)
