'''
Created on 2018. 12. 20.

@author: gdj4
'''

def func1():
    global a;  # 이 함수 안에서 a는 전역변수 global 예약어로 이 함수를 전역변수로 지정
    a = 10
    print("func1()에서 a값 %d" % a) # 지역변수 a

def func2():
    print("func2()에서 a값 %d"%a) #전역변수 a
    
a=20
func1()
func2()